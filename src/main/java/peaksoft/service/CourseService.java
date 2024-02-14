package peaksoft.service;

import peaksoft.entity.Course;

public interface CourseService {
    String saveCourseByCompanyId(Long companyId, Course course);
}
