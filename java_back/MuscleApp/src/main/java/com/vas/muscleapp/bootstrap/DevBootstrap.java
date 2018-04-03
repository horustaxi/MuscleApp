/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.bootstrap;

import com.vas.muscleapp.enums.Language;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.BodyMeasurements.BodyMeasurementsBuilder;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.models.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.vas.muscleapp.repositories.ExerciseRepository;
import com.vas.muscleapp.repositories.MuscleGroupRepository;
import com.vas.muscleapp.repositories.MuscleRepository;
import com.vas.muscleapp.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Vinícius
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;
    private final MuscleRepository muscleRepository;

    public DevBootstrap(
            UserRepository userRepository,
            MuscleGroupRepository muscleGroupRepository,
            MuscleRepository muscleRepository,
            ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
        this.muscleGroupRepository = muscleGroupRepository;
        this.muscleRepository = muscleRepository;
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
        initUsers();
        initMuscleGroups();
        initMuscles();
        initExercises();
    }

    private void initMuscleGroups() {
        //https://www.freetrainers.com/exercise/muscle/
        if (muscleGroupRepository.count() == 0) {
            List<MuscleGroup> muscleGroups = new ArrayList<>();
            muscleGroups.add(new MuscleGroup("Abs"));
            muscleGroups.add(new MuscleGroup("Arms"));
            muscleGroups.add(new MuscleGroup("Shoulders"));
            muscleGroups.add(new MuscleGroup("Back"));
            muscleGroups.add(new MuscleGroup("Legs"));
            muscleGroups.add(new MuscleGroup("Buttocks"));
            muscleGroups.add(new MuscleGroup("Hips"));
            muscleGroups.add(new MuscleGroup("Chest"));
            muscleGroups.add(new MuscleGroup("Cardio"));

            muscleGroupRepository.saveAll(muscleGroups);
        }
    }

    private void initMuscles() {
        //https://www.freetrainers.com/exercise/muscle/
        if (muscleRepository.count() == 0) {
            List<Muscle> muscles = new ArrayList<>();
            long x = muscleGroupRepository.count();
            MuscleGroup muscleGroup = muscleGroupRepository.findMuscleGroupByName("abs");
            muscles.add(new Muscle("Abdominals", muscleGroup));
            muscles.add(new Muscle("Obliques", muscleGroup));
            muscles.add(new Muscle("Serratus Anterior", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("arms");
            muscles.add(new Muscle("Biceps", muscleGroup));
            muscles.add(new Muscle("Forearms", muscleGroup));
            muscles.add(new Muscle("Triceps", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("shoulders");
            muscles.add(new Muscle("Anterior Delts", muscleGroup));
            muscles.add(new Muscle("Lateral Delts", muscleGroup));
            muscles.add(new Muscle("Posterior Delts", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("back");
            muscles.add(new Muscle("Erector Spinae", muscleGroup));
            muscles.add(new Muscle("Infraspinatus", muscleGroup));
            muscles.add(new Muscle("Latissimus dorsi (Lats)", muscleGroup));
            muscles.add(new Muscle("Teres", muscleGroup));
            muscles.add(new Muscle("Trapezius", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("legs");
            muscles.add(new Muscle("Calves", muscleGroup));
            muscles.add(new Muscle("Hamstrings", muscleGroup));
            muscles.add(new Muscle("Quads", muscleGroup));
            muscles.add(new Muscle("Sartorius", muscleGroup));
            muscles.add(new Muscle("Tibialis Anterior", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("buttocks");
            muscles.add(new Muscle("Gluteus maximus", muscleGroup));
            muscles.add(new Muscle("Gluteus medius", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("hips");
            muscles.add(new Muscle("Hip adductors", muscleGroup));
            muscles.add(new Muscle("Hip Flexors", muscleGroup));
            muscles.add(new Muscle("Tensor fasciae latae", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("chest");
            muscles.add(new Muscle("Pectoralis Major", muscleGroup));

            muscleGroup = muscleGroupRepository.findMuscleGroupByName("cardio");
            muscles.add(new Muscle("Heart", muscleGroup));
            muscles.add(new Muscle("Conditioning", muscleGroup));

            muscleRepository.saveAll(muscles);
        }
    }

    private void initExercises() {
        Exercise exercise = new Exercise("Crunch", "The crunch is performed while lying face up on the floor with knees bent, by curling the shoulders up towards the pelvis. This is an isolation exercise for the abdominals", Language.ENGLISH);
        exercise.getMainMuscles().add(muscleRepository.findMuscleByName("abdominals"));
        exercise.getSecondaryMuscles().add(muscleRepository.findMuscleByName("obliques"));
        exercise.getSecondaryMuscles().add(muscleRepository.findMuscleByName("serratus anterior"));
        exerciseRepository.save(exercise);
    }

    private void initUsers() throws Exception {
        if (userRepository.count() == 0) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            User userVinicius = new User("Vinicius A. dos Santos", "vinicius.vas.ti@gmail.com", bCryptPasswordEncoder.encode("123456"));
            User userEdson = new User("Edson Pereira", "edson.pereira@gmail.com", bCryptPasswordEncoder.encode("123456"));
            User userTiago = new User("Tiago Oliveira", "tiago.oliveira@gmail.com", bCryptPasswordEncoder.encode("123456"));

            BodyMeasurements bodyMeasurements = new BodyMeasurementsBuilder(userTiago, userEdson)
                    .setAge(27)
                    .setChest(76)
                    .setGlutes(80)
                    .setHeight(179)
                    .setLeftArm(34)
                    .setRightArm(34.5f)
                    .setLeftCalf(32.3f)
                    .setRightCalf(32.7f)
                    .setLeftForearm(25.2f)
                    .setRightForearm(25)
                    .setLeftThigh(47)
                    .setRightThigh(47.8f)
                    .setShoulders(94.6f)
                    .setWaist(80)
                    .setWeight(70)
                    .buildBodyMeasurements();
            userTiago.getBodyMeasurementses().add(bodyMeasurements);
            userRepository.save(userVinicius);
            userRepository.save(userEdson);
            userRepository.save(userTiago);
        }
    }
}
