package com.javatechie.utils;

import com.javatechie.dto.CourseRequestDTO;
import com.javatechie.dto.CourseResponseDTO;
import com.javatechie.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUtils {

    public static CourseEntity requestMappingToEntity(CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setFacultyName(courseRequestDTO.getFacultyName());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setDate(courseRequestDTO.getDate());
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setPhone(courseRequestDTO.getPhone());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());

        return courseEntity;
    }
    public static CourseResponseDTO entityMappingToResponseType(CourseEntity courseEntity){
        CourseResponseDTO courseResponseDTO=new CourseResponseDTO();
        courseResponseDTO.setCourseName(courseEntity.getCourseName());
        courseResponseDTO.setFacultyName(courseEntity.getFacultyName());
        courseResponseDTO.setCourseType(courseEntity.getCourseType());
        courseResponseDTO.setDate(courseEntity.getDate());
        courseResponseDTO.setDescription(courseEntity.getDescription());
        courseResponseDTO.setEmail(courseEntity.getEmail());
        courseResponseDTO.setFees(courseEntity.getFees());
        courseResponseDTO.setPhone(courseEntity.getPhone());

       return courseResponseDTO;

    }
}
