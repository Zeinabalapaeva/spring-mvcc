package peaksoft.repository;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyRepository {

    // crud methods

    List<Company> getAllCompanies();

    String saveCompany(Company company);

    Company findById(Long id);

    String updateById(Long id, Company newCompany);

    void deleteById(Long id);
}
