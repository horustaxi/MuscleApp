/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.bootstrap;

import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.repositories.IExerciseRepository;
import com.vas.muscleapp.repositories.IUserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vinícius
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private IUserRepository userRepository;
    private IExerciseRepository exerciseRepository;

    public DevBootstrap(IUserRepository userRepository, IExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initData();
    }

    private void initData() {
        //User
        User user = new User("Vinicius", "vinicius.vas.ti@gmail.com", "$2a$10$wRX4a2YRolkkLaMlHngCEuFrq19FajntkkXPdpp9a9N4ubH8Ki5yy", (short) 0);
        userRepository.save(user);

        //Exercises
        Exercise squat = new Exercise("Squat", "Quadriceps", "Hamstrings, Gluteus, Hips", "Squat is a compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks, quadriceps femoris muscle (vastus lateralis, vastus medialis, vastus intermedius and rectus femoris), hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body");
        exerciseRepository.save(squat);
        Exercise legPress = new Exercise("Leg press", "Quadriceps", "Gluteus", "leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs");
        exerciseRepository.save(legPress);
        Exercise benchPress = new Exercise("Bench press", "Pectorals", "Deltoids, Triceps", "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps");
        exerciseRepository.save(benchPress);
    }
}
