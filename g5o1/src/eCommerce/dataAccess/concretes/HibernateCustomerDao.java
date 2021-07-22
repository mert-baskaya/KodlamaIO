package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao{
	
	private List<Customer> customerList = new ArrayList<Customer>();

	@Override
	public void add(Customer customer) {
		customerList.add(customer);
		System.out.println("Veritabanina eklendi: " + customer.getCustomerEmail());
		
	}

	@Override
	public void delete(Customer customer) {
		customerList.remove(customer);
		System.out.println("Veritabanindan silindi: " + customer.getCustomerEmail());
		
	}

	@Override
	public void update(Customer customer) {
		//id read only olmak zorunda!
		int index = 0;
		for (Customer tempCustomer : customerList) {
			index++;
			if(tempCustomer.getCustomerId() == customer.getCustomerId()) {
				customerList.add(index, customer);
				System.out.println("Veritabaninda guncellendi: " + customer.getCustomerEmail());
				return;
			}
		}
		System.out.println("Hata! musteri bulunamadi");
	}

	@Override
	public Customer get(int id) {
		
		for (Customer customer : customerList) {
			if(customer.getCustomerId() == id) {
				return customer;
			}
		}
		System.out.println("Hata! musteri bulunamadi");
		return null;
		
	}
	
	@Override
	public Customer get(String email) {
		
		for (Customer customer : customerList) {
			if(customer.getCustomerEmail() == email) {
				return customer;
			}
		}
		System.out.println("Hata! musteri bulunamadi");
		return null;
		
	}

	@Override
	public List<Customer> getAll() {
		return customerList;
	}

}
