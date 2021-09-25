awk '{print substr($7, 6, length($7)) " " substr($4, 1, length($4) -1)}'
