package live.leer.dao;

import java.util.List;

import live.leer.domain.Customer;

public interface CustomerDao {

    public List<Customer> findAll();
}
