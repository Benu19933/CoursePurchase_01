package com.javatechie.service;

import com.javatechie.dto.CourseRequestDTO;
import com.javatechie.dto.CourseResponseDTO;
import com.javatechie.entity.CourseEntity;
import com.javatechie.repository.CourseRepository;
import com.javatechie.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO onBoardingCourse(CourseRequestDTO courseRequestDTO){
            CourseEntity existingCourseEntity=AppUtils.requestMappingToEntity(courseRequestDTO);
            CourseEntity newCourseEntity=courseRepository.save(existingCourseEntity);
             CourseResponseDTO courseResponseDTO= AppUtils.entityMappingToResponseType(newCourseEntity);
             courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);

             return courseResponseDTO;

    }
    public List<CourseEntity> getAllCourse(){
        return courseRepository.findAll();
    }
    public CourseResponseDTO findCourseResponseById(Integer id){
        CourseEntity courseEntity=courseRepository.findById(id).orElseThrow(()->new IllegalArgumentException( id+" is not valid please give valid input.. "));
        return AppUtils.entityMappingToResponseType(courseEntity);
    }
    public CourseResponseDTO getCourseByName(String name){
        CourseEntity courseEntity=courseRepository.findByName(name);
        CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
        courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return courseResponseDTO;
    }

    public CourseResponseDTO getCourseByFees(Double fees){
       CourseEntity courseEntity= courseRepository.findByFees(fees);
       CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
       courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);
               return courseResponseDTO;
    }
    public List<CourseResponseDTO> getCourseResponseByCourseType(String courseType){
        List<CourseEntity> list= courseRepository.findByCourseType(courseType);
        List<CourseResponseDTO> responseDTO=new ArrayList<>();
        for(CourseEntity course : list){
            CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(course);
            courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);
            responseDTO.add(courseResponseDTO);
        }
        return responseDTO;
    }
    public List<CourseResponseDTO> getCourseResponseByCourseTypeAndFees(String courseType,Double fees){
        List<CourseEntity> courseEntityList=courseRepository.findByCourseTypeAndFees(courseType,fees);
        List<CourseResponseDTO> courseResponseDTOList=new ArrayList<>();
        for (CourseEntity courseEntity:courseEntityList){
            CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
            courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);
            courseResponseDTOList.add(courseResponseDTO);

        }
        return courseResponseDTOList;
    }
    public List<CourseResponseDTO> getCourseResponseByCourseTypeOrFees(String courseType,Double fees){
        List<CourseEntity> courseEntityList=courseRepository.findByCourseTypeOrFees(courseType,fees);
        List<CourseResponseDTO> courseResponseDTOList=new ArrayList<>();
        for (CourseEntity courseEntity:courseEntityList){
            CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
            courseResponseDTOList.add(courseResponseDTO);
        }
        return courseResponseDTOList;
    }
    public CourseResponseDTO updatedCourseById(Integer id, CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity=courseRepository.findById(id).get();
       // CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setFacultyName(courseRequestDTO.getFacultyName());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setDate(courseRequestDTO.getDate());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setPhone(courseRequestDTO.getPhone());
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());

        CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseRepository.save(courseEntity));
        courseResponseDTO.setUniqueCode(UUID.randomUUID().toString().split("-")[0]);


        return courseResponseDTO;
    }
    public String deleteCourseById(Integer id){
        courseRepository.deleteById(id);
        return id+" nomber of data is successfully delete";
    }

    public List<CourseResponseDTO> getCourseResponseByFees(Double fees){
        List<CourseEntity> courseEntityList=courseRepository.getCourseByFees(fees);
        List<CourseResponseDTO>courseResponseDTOList=new ArrayList<>();
        for (CourseEntity courseEntity:courseEntityList){
            CourseResponseDTO courseResponseDTO=AppUtils.entityMappingToResponseType(courseEntity);
            courseResponseDTOList.add(courseResponseDTO);
        }
        return courseResponseDTOList;
    }

}





























