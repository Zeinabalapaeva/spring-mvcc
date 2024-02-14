package peaksoft.repository;

import peaksoft.entity.Course;

public interface CourseRepository {

    String saveCourseByCompanyId(Long companyId, Course course);

}
