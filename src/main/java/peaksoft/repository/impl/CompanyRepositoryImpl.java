package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
       return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public String saveCompany(Company company) {
         entityManager.persist(company);
         return "Company saved!";
    }

    @Override
    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override // don't show, student to do
    public String updateById(Long id, Company newCompany) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }
}
