/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.vas.muscleapp.enums.Language;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.models.WorkoutPlan;
import com.vas.muscleapp.models.WorkoutSheet;
import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.models.WorksetExercise;
import com.vas.muscleapp.repositories.ExerciseRepository;
import com.vas.muscleapp.repositories.MuscleGroupRepository;
import com.vas.muscleapp.repositories.MuscleRepository;
import com.vas.muscleapp.repositories.UserRepository;
import com.vas.muscleapp.repositories.WorkoutPlanRepository;
import com.vas.muscleapp.repositories.WorkoutSheetRepository;
import com.vas.muscleapp.repositories.WorksetExerciseRepository;
import com.vas.muscleapp.repositories.WorksetRepository;

/**
 *
 * @author Vinícius
 */
// TODO refatorar para CommandLineRunner conforme SPG
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final UserRepository userRepository;
	private final ExerciseRepository exerciseRepository;
	private final MuscleGroupRepository muscleGroupRepository;
	private final MuscleRepository muscleRepository;
	private final WorkoutPlanRepository workoutPlanRepository;
	private final WorkoutSheetRepository workoutSheetRepository;
	private final WorksetRepository worksetRepository;
	private final WorksetExerciseRepository worksetExerciseRepository;

	public DevBootstrap(UserRepository userRepository, MuscleGroupRepository muscleGroupRepository,
			MuscleRepository muscleRepository, WorkoutPlanRepository workoutPlanRepository,
			WorkoutSheetRepository workoutSheetRepository, WorksetRepository worksetRepository,
			WorksetExerciseRepository worksetExerciseRepository,
			ExerciseRepository exerciseRepository) {
		this.userRepository = userRepository;
		this.exerciseRepository = exerciseRepository;
		this.muscleGroupRepository = muscleGroupRepository;
		this.muscleRepository = muscleRepository;
		this.workoutPlanRepository = workoutPlanRepository;
		this.workoutSheetRepository = workoutSheetRepository;
		this.worksetRepository = worksetRepository;
		this.worksetExerciseRepository = worksetExerciseRepository;
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
		initWorkoutPlans();
	}

	private void initMuscleGroups() {
		// https://www.freetrainers.com/exercise/muscle/
		if (muscleGroupRepository.count() == 0) {
			List<MuscleGroup> muscleGroups = new ArrayList<>();
			muscleGroups.add(new MuscleGroup("Abs", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Arms", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Shoulders", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Back", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Legs", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Buttocks", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Hips", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Chest", Language.ENGLISH));
			muscleGroups.add(new MuscleGroup("Cardio", Language.ENGLISH));

			muscleGroupRepository.saveAll(muscleGroups);
		}
	}

	private void initMuscles() {
		// https://www.freetrainers.com/exercise/muscle/
		if (muscleRepository.count() == 0) {
			List<Muscle> muscles = new ArrayList<>();

			MuscleGroup muscleGroup = muscleGroupRepository.findMuscleGroupByName("abs").get();
			muscles.add(new Muscle("Abdominals", muscleGroup, Language.ENGLISH));
			muscles.add(new Muscle("Obliques", muscleGroup, Language.ENGLISH));
			muscles.add(new Muscle("Serratus Anterior", muscleGroup, Language.ENGLISH));

			MuscleGroup muscleGroup2 = muscleGroupRepository.findMuscleGroupByName("arms").get();
			muscles.add(new Muscle("Biceps", muscleGroup2, Language.ENGLISH));
			muscles.add(new Muscle("Forearms", muscleGroup2, Language.ENGLISH));
			muscles.add(new Muscle("Triceps", muscleGroup2, Language.ENGLISH));

			MuscleGroup muscleGroup3 = muscleGroupRepository.findMuscleGroupByName("shoulders")
					.get();
			muscles.add(new Muscle("Anterior Delts", muscleGroup3, Language.ENGLISH));
			muscles.add(new Muscle("Lateral Delts", muscleGroup3, Language.ENGLISH));
			muscles.add(new Muscle("Posterior Delts", muscleGroup3, Language.ENGLISH));

			MuscleGroup muscleGroup4 = muscleGroupRepository.findMuscleGroupByName("back").get();
			muscles.add(new Muscle("Erector Spinae", muscleGroup4, Language.ENGLISH));
			muscles.add(new Muscle("Infraspinatus", muscleGroup4, Language.ENGLISH));
			muscles.add(new Muscle("Lats", muscleGroup4, Language.ENGLISH));
			muscles.add(new Muscle("Teres", muscleGroup4, Language.ENGLISH));
			muscles.add(new Muscle("Trapezius", muscleGroup4, Language.ENGLISH));

			MuscleGroup muscleGroup5 = muscleGroupRepository.findMuscleGroupByName("legs").get();
			muscles.add(new Muscle("Calves", muscleGroup5, Language.ENGLISH));
			muscles.add(new Muscle("Hamstrings", muscleGroup5, Language.ENGLISH));
			muscles.add(new Muscle("Quads", muscleGroup5, Language.ENGLISH));
			muscles.add(new Muscle("Sartorius", muscleGroup5, Language.ENGLISH));
			muscles.add(new Muscle("Tibialis Anterior", muscleGroup5, Language.ENGLISH));

			MuscleGroup muscleGroup6 = muscleGroupRepository.findMuscleGroupByName("buttocks")
					.get();
			muscles.add(new Muscle("Gluteus maximus", muscleGroup6, Language.ENGLISH));
			muscles.add(new Muscle("Gluteus medius", muscleGroup6, Language.ENGLISH));

			MuscleGroup muscleGroup7 = muscleGroupRepository.findMuscleGroupByName("hips").get();
			muscles.add(new Muscle("Hip adductors", muscleGroup7, Language.ENGLISH));
			muscles.add(new Muscle("Hip Flexors", muscleGroup7, Language.ENGLISH));
			muscles.add(new Muscle("Tensor fasciae latae", muscleGroup7, Language.ENGLISH));

			MuscleGroup muscleGroup8 = muscleGroupRepository.findMuscleGroupByName("chest").get();
			muscles.add(new Muscle("Pectoralis Major", muscleGroup8, Language.ENGLISH));

			MuscleGroup muscleGroup9 = muscleGroupRepository.findMuscleGroupByName("cardio").get();
			muscles.add(new Muscle("Heart", muscleGroup9, Language.ENGLISH));
			muscles.add(new Muscle("Conditioning", muscleGroup9, Language.ENGLISH));

			muscleRepository.saveAll(muscles);
		}
	}

	private void initExercises() {
		// https://en.wikipedia.org/wiki/List_of_weight_training_exercises#Deadlift
		if (exerciseRepository.count() == 0) {
			List<Exercise> exercises = new ArrayList<>();
			Exercise crunch = new Exercise("Crunch",
					"The crunch is performed while lying face up on the floor with knees bent, by curling the shoulders up towards the pelvis. This is an isolation exercise for the abdominals.",
					Language.ENGLISH);
			crunch.getMainMuscles().add(muscleRepository.findMuscleByName("abdominals").get());
			crunch.getSecondaryMuscles().add(muscleRepository.findMuscleByName("obliques").get());
			crunch.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("serratus anterior").get());
			exercises.add(crunch);

			Exercise legRaise = new Exercise("leg raise",
					"The leg raise is performed while sitting on a bench or flat on the floor by raising the knees towards the shoulders, or legs to a vertical upright position. This is a compound exercise that also involves the hip flexors.",
					Language.ENGLISH);
			legRaise.getMainMuscles().add(muscleRepository.findMuscleByName("abdominals").get());
			legRaise.getSecondaryMuscles().add(muscleRepository.findMuscleByName("obliques").get());
			legRaise.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("serratus anterior").get());
			legRaise.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("hip flexors").get());
			exercises.add(legRaise);

			Exercise squat = new Exercise("squat",
					"The squat is performed by squatting down with a weight held across the upper back under neck and standing up straight again.",
					Language.ENGLISH);
			squat.getMainMuscles().add(muscleRepository.findMuscleByName("quads").get());
			squat.getMainMuscles().add(muscleRepository.findMuscleByName("gluteus maximus").get());
			squat.getSecondaryMuscles().add(muscleRepository.findMuscleByName("calves").get());
			squat.getSecondaryMuscles().add(muscleRepository.findMuscleByName("hamstrings").get());
			squat.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("erector spinae").get());
			squat.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("infraspinatus").get());
			exercises.add(squat);

			Exercise legPress = new Exercise("Leg press",
					"The leg press is performed while seated by pushing a weight away from the body with the feet.",
					Language.ENGLISH);
			legPress.getMainMuscles().add(muscleRepository.findMuscleByName("quads").get());
			legPress.getMainMuscles()
					.add(muscleRepository.findMuscleByName("gluteus maximus").get());
			legPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("hamstrings").get());
			legPress.getSecondaryMuscles().add(muscleRepository.findMuscleByName("calves").get());
			exercises.add(legPress);

			Exercise deadlift = new Exercise("Deadlift",
					"The deadlift is performed by squatting down and lifting a weight off the floor with the hand until standing up straight again. Grips can be face down or opposing with one hand down and one hand up, to prevent dropping. Face up should not be used because this puts excess stress on the inner arms.",
					Language.ENGLISH);
			deadlift.getMainMuscles().add(muscleRepository.findMuscleByName("lats").get());
			deadlift.getMainMuscles().add(muscleRepository.findMuscleByName("trapezius").get());
			deadlift.getMainMuscles().add(muscleRepository.findMuscleByName("infraspinatus").get());
			deadlift.getMainMuscles()
					.add(muscleRepository.findMuscleByName("erector spinae").get());
			deadlift.getMainMuscles()
					.add(muscleRepository.findMuscleByName("gluteus maximus").get());
			deadlift.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("hamstrings").get());
			deadlift.getSecondaryMuscles().add(muscleRepository.findMuscleByName("forearms").get());
			deadlift.getSecondaryMuscles().add(muscleRepository.findMuscleByName("calves").get());
			exercises.add(deadlift);

			Exercise barbellRow = new Exercise("barbell row", "The barbell row.", Language.ENGLISH);
			barbellRow.getMainMuscles().add(muscleRepository.findMuscleByName("lats").get());
			barbellRow.getMainMuscles().add(muscleRepository.findMuscleByName("trapezius").get());
			barbellRow.getMainMuscles()
					.add(muscleRepository.findMuscleByName("infraspinatus").get());
			barbellRow.getSecondaryMuscles().add(muscleRepository.findMuscleByName("biceps").get());
			barbellRow.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("forearms").get());
			exercises.add(barbellRow);

			Exercise legExtension = new Exercise("Leg extension",
					"The leg extension is performed while seated by raising a weight out in front of the body with the feet. It is an isolation exercise for the quadriceps.",
					Language.ENGLISH);
			legExtension.getMainMuscles().add(muscleRepository.findMuscleByName("quads").get());
			exercises.add(legExtension);

			Exercise legCurl = new Exercise("Leg curl",
					"The leg curl is performed while lying face down on a bench, by raising a weight with the feet towards the buttocks. This is an isolation exercise for the hamstrings.",
					Language.ENGLISH);
			legCurl.getMainMuscles().add(muscleRepository.findMuscleByName("hamstrings").get());
			exercises.add(legCurl);

			Exercise stiff = new Exercise("Stiff-Legged Deadlift",
					"The Stiff-Legged Deadlift is a deadlift variation that specifically targets the posterior chain. Little to no knee movement occurs in this exercise to ensure hamstring, glute, and spinal erector activation. The bar starts on the floor and the individual sets up like a normal deadlift but the knees are at a 160° angle instead on 135° on the conventional deadlift. The person picks the bar up from the ground with a straight back to prevent snap city.",
					Language.ENGLISH);
			stiff.getMainMuscles().add(muscleRepository.findMuscleByName("gluteus maximus").get());
			stiff.getMainMuscles().add(muscleRepository.findMuscleByName("hamstrings").get());
			stiff.getMainMuscles().add(muscleRepository.findMuscleByName("infraspinatus").get());
			stiff.getMainMuscles().add(muscleRepository.findMuscleByName("erector spinae").get());
			stiff.getSecondaryMuscles().add(muscleRepository.findMuscleByName("forearms").get());
			exercises.add(stiff);

			Exercise standingCalfRaise = new Exercise("Standing calf raise",
					"The standing calf raise is performed by plantarflexing the feet to lift the body. If a weight is used, then it rests upon the shoulders, or is held in the hand(s). This is an isolation exercise for the calves; it particularly emphasises the gastrocnemius muscle, and recruits the soleus muscle.",
					Language.ENGLISH);
			standingCalfRaise.getMainMuscles()
					.add(muscleRepository.findMuscleByName("calves").get());
			exercises.add(standingCalfRaise);

			Exercise seatedCalfRaise = new Exercise("Seated calf raise",
					"The seated calf raise is performed by flexing the feet to lift a weight held on the knees. This is an isolation exercise for the calves, and particularly emphasises the soleus muscle.",
					Language.ENGLISH);
			seatedCalfRaise.getMainMuscles().add(muscleRepository.findMuscleByName("calves").get());
			exercises.add(seatedCalfRaise);

			Exercise benchPress = new Exercise("bench press",
					"The bench press or dumbbell bench-press is performed while lying face up on a bench, by pushing a weight away from the chest.",
					Language.ENGLISH);
			benchPress.getMainMuscles()
					.add(muscleRepository.findMuscleByName("pectoralis major").get());
			benchPress.getMainMuscles().add(muscleRepository.findMuscleByName("triceps").get());
			benchPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("anterior delts").get());
			exercises.add(benchPress);

			Exercise chestFly = new Exercise("chest fly",
					"The chest fly is performed while lying face up on a bench or standing up, with arms outspread holding weights, by bringing the arms together above the chest.",
					Language.ENGLISH);
			chestFly.getMainMuscles()
					.add(muscleRepository.findMuscleByName("pectoralis major").get());
			chestFly.getSecondaryMuscles().add(muscleRepository.findMuscleByName("forearms").get());
			chestFly.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("anterior delts").get());
			exercises.add(chestFly);

			Exercise pulldown = new Exercise("pulldown",
					"The pulldown is performed while seated by pulling a wide bar down towards the upper chest.",
					Language.ENGLISH);
			pulldown.getMainMuscles().add(muscleRepository.findMuscleByName("lats").get());
			pulldown.getSecondaryMuscles().add(muscleRepository.findMuscleByName("biceps").get());
			pulldown.getSecondaryMuscles().add(muscleRepository.findMuscleByName("forearms").get());
			pulldown.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("posterior delts").get());
			exercises.add(pulldown);

			Exercise chinUp = new Exercise("Pull-up",
					"The Pull-up is performed by hanging from a chin-up bar above head height with the palms facing forward (supinated) and pulling the body up so the chin reaches or passes the bar.",
					Language.ENGLISH);
			chinUp.getMainMuscles().add(muscleRepository.findMuscleByName("lats").get());
			chinUp.getSecondaryMuscles().add(muscleRepository.findMuscleByName("biceps").get());
			chinUp.getSecondaryMuscles().add(muscleRepository.findMuscleByName("forearms").get());
			chinUp.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("posterior delts").get());
			exercises.add(chinUp);

			Exercise uprightRow = new Exercise("upright row",
					"The upright row is performed while standing, holding a weight hanging down in the hands, by lifting it straight up to the collarbone.",
					Language.ENGLISH);
			uprightRow.getMainMuscles()
					.add(muscleRepository.findMuscleByName("lateral delts").get());
			uprightRow.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("posterior delts").get());
			uprightRow.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("trapezius").get());
			uprightRow.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("forearms").get());
			exercises.add(uprightRow);

			Exercise shoulderPress = new Exercise("shoulder press",
					"The shoulder press is performed while seated, or standing by lowering a weight held above the head to just above the shoulders, and then raising it again.",
					Language.ENGLISH);
			shoulderPress.getMainMuscles()
					.add(muscleRepository.findMuscleByName("anterior delts").get());
			shoulderPress.getMainMuscles().add(muscleRepository.findMuscleByName("triceps").get());
			shoulderPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("lateral delts").get());
			shoulderPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("trapezius").get());
			exercises.add(shoulderPress);

			Exercise ohp = new Exercise("over head press",
					"The shoulder press is performed while seated, or standing by lowering a weight held above the head to just above the shoulders, and then raising it again.",
					Language.ENGLISH);
			ohp.getMainMuscles().add(muscleRepository.findMuscleByName("anterior delts").get());
			ohp.getMainMuscles().add(muscleRepository.findMuscleByName("triceps").get());
			ohp.getSecondaryMuscles().add(muscleRepository.findMuscleByName("lateral delts").get());
			ohp.getSecondaryMuscles().add(muscleRepository.findMuscleByName("trapezius").get());
			exercises.add(ohp);

			Exercise militaryPress = new Exercise("military press",
					"The military press is similar to the shoulder press but is performed while standing with the feet together. (It is named \"military\" because of the similarity in appearance to the \"at attention\" position used in most militaries) Unlike the seated shoulder press, the military press involves the majority of the muscles of the core as stabilizers to keep the body rigid and upright, and is thus a more effective compound exercise.",
					Language.ENGLISH);
			militaryPress.getMainMuscles()
					.add(muscleRepository.findMuscleByName("anterior delts").get());
			militaryPress.getMainMuscles().add(muscleRepository.findMuscleByName("triceps").get());
			militaryPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("lateral delts").get());
			militaryPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("trapezius").get());
			militaryPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("abdominals").get());
			militaryPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("erector spinae").get());
			militaryPress.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("infraspinatus").get());
			exercises.add(militaryPress);

			Exercise lateralRaise = new Exercise("lateral raise",
					"The lateral raise (or shoulder fly) is performed while standing or seated, with hands hanging down holding weights, by lifting them out to the sides until just below the level of the shoulders. A slight variation in the lifts can hit the deltoids even harder, while moving upwards, just turn the hands slightly downwards, keeping the last finger higher than the thumb. This is an isolation exercise for the deltoids.",
					Language.ENGLISH);
			lateralRaise.getMainMuscles()
					.add(muscleRepository.findMuscleByName("lateral delts").get());
			lateralRaise.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("posterior delts").get());
			exercises.add(lateralRaise);

			Exercise pushdown = new Exercise("pushdown",
					"The pushdown is performed while standing by pushing down on a bar held at the level of the upper chest. It is important to keep the elbows at shoulder width and in line with shoulder/legs. In other words, elbows position should not change while moving the forearm pushes down the bar. This is an isolation exercise for the triceps.",
					Language.ENGLISH);
			pushdown.getMainMuscles().add(muscleRepository.findMuscleByName("triceps").get());
			exercises.add(pushdown);

			Exercise tricepsExtension = new Exercise("triceps extension",
					"The triceps extension is performed while standing or seated, by lowering a weight held above the head (keeping the upper arms motionless), and then raising it again. It can be performed with both arms, or one arm at a time. This is an isolation exercise for the triceps. It is also known as the french curl.",
					Language.ENGLISH);
			tricepsExtension.getMainMuscles()
					.add(muscleRepository.findMuscleByName("triceps").get());
			exercises.add(tricepsExtension);

			Exercise preacherCurl = new Exercise("Preacher curl",
					"The Preacher curl is performed while standing or seated, with hands hanging down holding weights (palms facing forwards), by curling them up to the shoulders. It can be performed with both arms, or one arm at a time.",
					Language.ENGLISH);
			preacherCurl.getMainMuscles().add(muscleRepository.findMuscleByName("biceps").get());
			preacherCurl.getSecondaryMuscles()
					.add(muscleRepository.findMuscleByName("forearms").get());
			exercises.add(preacherCurl);

			exerciseRepository.saveAll(exercises);
		}
	}

	private void initUsers() throws Exception {
		if (userRepository.count() == 0) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			User userVinicius = new User("Vinicius A. dos Santos", "vinicius.vas.ti@gmail.com",
					bCryptPasswordEncoder.encode("123456"));
			User userEdson = new User("Edson Pereira", "edson.pereira@gmail.com",
					bCryptPasswordEncoder.encode("123456"));
			User userTiago = new User("Tiago Oliveira", "tiago.oliveira@gmail.com",
					bCryptPasswordEncoder.encode("123456"));

			BodyMeasurements bodyMeasurements = new BodyMeasurements.Builder(userTiago, userEdson)
					.setAge(27).setChest(76).setGlutes(80).setHeight(179).setLeftArm(34)
					.setRightArm(34.5f).setLeftCalf(32.3f).setRightCalf(32.7f).setLeftForearm(25.2f)
					.setRightForearm(25).setLeftThigh(47).setRightThigh(47.8f).setShoulders(94.6f)
					.setWaist(80).setWeight(70).build();
			userTiago.getBodyMeasurements().add(bodyMeasurements);
			userRepository.save(userVinicius);
			userRepository.save(userEdson);
			userRepository.save(userTiago);
		}
	}

	private void initWorkoutPlans() {
		if (workoutPlanRepository.count() == 0) {
			WorkoutPlan workoutPlan1 = new WorkoutPlan("Primeiro Treino",
					userRepository.findUserByEmail("edson.pereira@gmail.com").get(),
					userRepository.findUserByEmail("tiago.oliveira@gmail.com").get());
			workoutPlanRepository.save(workoutPlan1);

			// WorkoutSheet
			WorkoutSheet workoutSheet1 = new WorkoutSheet("Ficha 1", workoutPlan1);
			workoutSheetRepository.save(workoutSheet1);

			// Workset
			Workset worksetA = new Workset('A', workoutSheet1);
			Workset worksetB = new Workset('B', workoutSheet1);
			worksetRepository.saveAll(Arrays.asList(worksetA, worksetB));

			// WorksetExercise
			WorksetExercise supino = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("squat").get(), worksetA);
			WorksetExercise agachamento = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("bench press").get(), worksetA);
			WorksetExercise remada = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("barbell row").get(), worksetA);

			WorksetExercise agachamentoB = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("squat").get(), worksetB);
			WorksetExercise ohp = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("over head press").get(), worksetB);
			WorksetExercise deadlift = new WorksetExercise("5", "5", new Short("180"),
					"Carga submáxima de 70% da 1RM",
					exerciseRepository.findExerciseByName("deadlift").get(), worksetB);
			worksetExerciseRepository.saveAll(
					Arrays.asList(agachamento, supino, remada, agachamentoB, ohp, deadlift));
		}
	}
}
