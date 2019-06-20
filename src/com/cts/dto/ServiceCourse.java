package com.cts.dto;

public class ServiceCourse {
	Service serviceId;
	Course courseId;
	public Service getServiceId() {
		return serviceId;
	}
	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}
	@Override
	public String toString() {
		return "ServiceCourse [serviceId=" + serviceId + ", courseId=" + courseId + "]";
	}
	public ServiceCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceCourse(Service serviceId, Course courseId) {
		super();
		this.serviceId = serviceId;
		this.courseId = courseId;
	}
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

}
