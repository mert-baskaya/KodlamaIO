package abstracts;

import entities.Customer;

public interface CustomerService {
	void add(Customer customer);

	Customer get(int id);

	void edit(Customer customer);

	void delete(int id);
}
