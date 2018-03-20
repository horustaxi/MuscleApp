/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.bootstrap;

import com.vas.muscleapp.bodyMeasurements.BodyMeasurements;
import com.vas.muscleapp.bodyMeasurements.BodyMeasurements.BodyMeasurementsBuilder;
import com.vas.muscleapp.enums.ProfileEnum;
import com.vas.muscleapp.exercise.Exercise;
import com.vas.muscleapp.user.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.vas.muscleapp.exercise.ExerciseRepository;
import com.vas.muscleapp.user.UserRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    public DevBootstrap(UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        try {
            initData();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DevBootstrap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initData() throws Exception {
        //User
        User userVinicius = new User("Vinicius A. dos Santos", "vinicius.vas.ti@gmail.com",
                "123456",
                (short) ProfileEnum.Administrator.profileValue);
        User userEdson = new User("Edson Pereira", "edson.pereira@gmail.com",
                "123456",
                (short) ProfileEnum.PersonalTrainner.profileValue);
        User userTiago = new User("Tiago Oliveira", "tiago.oliveira@gmail.com",
                "123456",
                (short) ProfileEnum.SimpleUser.profileValue);
        BodyMeasurements bodyMeasurements = new BodyMeasurementsBuilder(userTiago, userEdson)
                .setAge(0)
                .setChest(0)
                .setGlutes(0)
                .setHeight(0)
                .setLeftArm(0)
                .setRightArm(0)
                .setLeftCalf(0)
                .setRightCalf(0)
                .setLeftForearm(0)
                .setRightForearm(0)
                .setLeftThigh(0)
                .setRightThigh(0)
                .setShoulders(0)
                .setWaist(0)
                .setWeight(0)
                .buildPerson();
        userTiago.getBodyMeasurementses().add(bodyMeasurements);
        userRepository.save(userVinicius);
        userRepository.save(userEdson);
        userRepository.save(userTiago);

        //Exercises
        Exercise squat = new Exercise("Squat", "Quadriceps", "Hamstrings, Gluteus, Hips", "Squat is a compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks, quadriceps femoris muscle (vastus lateralis, vastus medialis, vastus intermedius and rectus femoris), hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body");
        exerciseRepository.save(squat);
        Exercise legPress = new Exercise("Leg press", "Quadriceps", "Gluteus", "leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs");
        exerciseRepository.save(legPress);
        Exercise benchPress = new Exercise("Bench press", "Pectorals", "Deltoids, Triceps", "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps");
        exerciseRepository.save(benchPress);
    }
}
