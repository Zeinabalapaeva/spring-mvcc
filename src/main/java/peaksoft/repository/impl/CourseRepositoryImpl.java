package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveCourseByCompanyId(Long companyId, Course course) {
        Company company = entityManager.find(Company.class, companyId);
        course.setCompany(company);
        company.getCourses().add(course);
        entityManager.persist(course);
        return "Course saved!";
    }
}
