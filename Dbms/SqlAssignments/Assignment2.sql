/*1. Find out the number of documentaries with deleted scenes.*/
select count(distinct film.title) as numberOfDocumentariesWIthDeletedScenes
	from((film_category inner join film on film.film_id=film_category.film_id)
			inner join category on film_category.category_id=category.category_id) 
            where film.special_features like "%Deleted Scenes%" and category.name='Documentary';
	
/*
2. Find out the number of sci-fi movies rented by the store managed by Jon Stephens.*/
select count(distinct film_list.title) 
	from film_list,inventory,staff,store 
    where film_list.category='Sci-Fi' 
    and film_list.fid=inventory.film_id 
    and inventory.store_id=store.store_id
    and store.manager_staff_id=staff.staff_id
    and staff.first_name="Jon"
    and staff.last_name="Stephens";
            
            
/*3. Find out the total sales from Animation movies.*/
select total_sales from sales_by_film_category where sales_by_film_category.category='Animation';


/*4. Find out the top 3 rented category of movies by “PATRICIA JOHNSON”.*/
select film_list.category from
	(((film_list inner join inventory on film_list.fid=inventory.film_id)
	inner join rental on rental.inventory_id=inventory.inventory_id)
    inner join customer on rental.customer_id=customer.customer_id)
    where first_name='PATRICIA' and last_name='JOHNSON'
    group by film_list.category  order by count(film_list.category) desc limit 3;

    
    
/*5. Find out the number of R rated movies rented by “SUSAN WILSON”.*/
select count(*) from film_list,inventory,rental,customer
	where rating='R'
    and film_list.fid=inventory.film_id
    and inventory.inventory_id=rental.inventory_id
    and rental.customer_id=customer.customer_id
    and customer.first_name="SUSAN"
    and customer.last_name="WILSON";
