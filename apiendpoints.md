## MuscleApp Rest Endpoints
*Always use Header Authorization Bearer 'token', excepting for "/register" and "/login"*

### User

#### Sign Up
  - Post: https://muscle-app.herokuapp.com/register
  - Request body:
    ```json
    {
      "name" : "Marcus Jackson",
      "email" : "marcus.jackson@gmail.com",
      "password" : "123456"
    }
    ```
    
#### Login
  - Post: https://muscle-app.herokuapp.com/login
  - Request body:
    ```json
    {
      "email" : "marcus.jackson@gmail.com",
      "password" : "123456"
    }
    ```
  - Response Header token:
    `Authorization →Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXMuamFja3NvbkBnbWFpbC5jb20iLCJleHAiOjE1MjI5NDY0NTl9.V4vDd7TECki74THSVt2BIiKGHuquVr0X8BR6zh9RbaKExe5wvL5mTZRv-iWMDvVieWe1kVgEIQ5GH14nLQrZgg`

#### User (retrive user info from token)
  - Get: https://muscle-app.herokuapp.com/user
  - Response body:
    ```
    {
      "id": 8,
      "name": "Marcus Jackson",
      "email": "marcus.jackson@gmail.com",
      "password": "fakepassword",
      "createdAt": "2018-03-26T19:17:43.265+0000",
      "workoutSheets": null
    }
    ```

### User Body Measurements

#### Listing
  - Get: https://muscle-app.herokuapp.com/user/8/bodymeasurements
  - Response body:
  ```json
  [
    {
        "id": 9,
        "createdAt": "2018-03-26T23:02:06.343+0000",
        "age": 27,
        "height": 180,
        "weight": 83,
        "shoulders": 112.6,
        "chest": 93,
        "waist": 85,
        "rightArm": 37.5,
        "leftArm": 37,
        "rightForearm": 30,
        "leftForearm": 30.2,
        "rightThigh": 55.8,
        "leftThigh": 55,
        "rightCalf": 36.7,
        "leftCalf": 36.3,
        "glutes": 90,
        "personalTrainnerUser": {
            "id": 2,
            "name": "Edson Pereira",
            "email": "edson.pereira@gmail.com",
            "password": "$2a$10$A4NBW1cJhva8nETQFNBj7u4MW4WK3U.CMQUqi2pHPKL69i0X1IuIC",
            "createdAt": "2018-03-26T23:00:02.119+0000",
            "workoutSheets": []
        }
    },
    {
        "id": 10,
        "createdAt": "2018-03-26T23:06:00.198+0000",
        "age": 27,
        "height": 180,
        "weight": 88,
        "shoulders": 117.6,
        "chest": 97,
        "waist": 85,
        "rightArm": 39.5,
        "leftArm": 39,
        "rightForearm": 32,
        "leftForearm": 32.2,
        "rightThigh": 58.8,
        "leftThigh": 58,
        "rightCalf": 38.7,
        "leftCalf": 38.3,
        "glutes": 92,
        "personalTrainnerUser": {
            "id": 2,
            "name": "Edson Pereira",
            "email": "edson.pereira@gmail.com",
            "password": "$2a$10$A4NBW1cJhva8nETQFNBj7u4MW4WK3U.CMQUqi2pHPKL69i0X1IuIC",
            "createdAt": "2018-03-26T23:00:02.119+0000",
            "workoutSheets": []
        }
    }
  ]
  ```

#### Saving new
  - Post: https://muscle-app.herokuapp.com/user/8/bodymeasurements
  ```JSON
  {
    "age": 27,
    "height": 180,
    "weight": 83,
    "shoulders": 112.6,
    "chest": 93,
    "waist": 85,
    "rightArm": 37.5,
    "leftArm": 37,
    "rightForearm": 30,
    "leftForearm": 30.2,
    "rightThigh": 55.8,
    "leftThigh": 55,
    "rightCalf": 36.7,
    "leftCalf": 36.3,
    "glutes": 90,
    "personalTrainnerUser": {
        "id": 2
    }
  }
  ```

### Exercises
#### Listing
  - Get: https://muscle-app.herokuapp.com/exercises
  - Response body:
    ```json
    [
      {
          "id": 5,
          "name": "squat",
          "mainMuscle": "quadriceps",
          "secondaryMuscles": "hamstrings, gluteus, hips",
          "description": "Squat is a compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks, quadriceps femoris muscle (vastus lateralis, vastus medialis, vastus intermedius and rectus femoris), hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body"
      },
      {
          "id": 7,
          "name": "bench press",
          "mainMuscle": "pectorals",
          "secondaryMuscles": "deltoids, triceps",
          "description": "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps"
      }
    ]
    ```

#### Saving new
  - Post: https://muscle-app.herokuapp.com/exercises
  - Request body:
  ```json
  {
    "name": "leg press",
    "mainMuscle": "quadriceps",
    "secondaryMuscles": "gluteus",
    "description": "leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs"
  }
  ```
