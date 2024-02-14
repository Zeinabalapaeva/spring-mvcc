package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public String saveCompany(Company company) {
        return companyRepository.saveCompany(company);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public String updateById(Long id, Company newCompany) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
