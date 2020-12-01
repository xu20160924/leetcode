select customers.name as 'Customers'
from customers
where customers.id not in
(select customerid from orders)

select Name as 'Customers'
from Customers c
left join Orders o
on c.Id = o.CustomerId
where o.CustomerId is null