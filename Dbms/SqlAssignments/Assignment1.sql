/*1. Find out the PG-13 rated comedy movies. DO NOT use the film_list table.*/

select film.title,film.rating,category.name 
	from((film_category inner join film on film.film_id=film_category.film_id)
			inner join category on film_category.category_id=category.category_id) 
	where rating='PG-13' and category.name='Comedy';
    
 /* 2. Find out the top 3 rented horror movies. */
 
select distinct film.title
	from((((film_category inner join film on film.film_id=film_category.film_id) 
    inner join category on film_category.category_id=category.category_id) 
    inner join inventory on film.film_id=inventory.film_id)
    inner join rental on inventory.inventory_id=rental.inventory_id)
    where category.name="Horror" group by film.title order by count(film.title) desc limit 3;

/*3. Find out the list of customers from India who have rented sports movies.*/

select distinct concat(customer.first_name,' ',customer.last_name) as customer_name,country 
	from((((((((film_category inner join film on film.film_id=film_category.film_id)
			inner join category on film_category.category_id=category.category_id)
            inner join inventory on film.film_id=inventory.film_id)
            inner join rental on inventory.inventory_id=rental.inventory_id)
            inner join customer on rental.customer_id=customer.customer_id)
            inner join address on address.address_id=customer.address_id)
            inner join city on city.city_id=address.city_id)
            inner join country on country.country_id=city.country_id)
	where country='India' and category.name='Sports' order by customer_name;


/*4. Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies.*/
    
select distinct concat(customer.first_name,' ',customer.last_name) as customer_name,country 
	from((((((((film_actor inner join film on film.film_id=film_actor.film_id)
			inner join actor on film_actor.actor_id=actor.actor_id)
            inner join inventory on film.film_id=inventory.film_id)
            inner join rental on inventory.inventory_id=rental.inventory_id)
            inner join customer on rental.customer_id=customer.customer_id)
            inner join address on address.address_id=customer.address_id)
            inner join city on city.city_id=address.city_id)
            inner join country on country.country_id=city.country_id)
	where country='Canada' and actor.first_name = 'NICK' and actor.last_name = 'WAHLBERG' order by customer_name;
    
/*5. Find out the number of movies in which “SEAN WILLIAMS” acted.*/

select count(*) as NumberOfMovies from((film_actor inner join film on film.film_id=film_actor.film_id)
			inner join actor on film_actor.actor_id=actor.actor_id)
		where actor.first_name = 'SEAN' and actor.last_name = 'WILLIAMS';
