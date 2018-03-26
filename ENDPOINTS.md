## MuscleApp Rest Endpoints
*Always use Header Authorization Bearer 'token', excepting for "/register" and "/login"*

### Sign Up
  - Post: https://muscle-app.herokuapp.com/register
  - Request body:
    ```json
    {
      "name" : "Marcus Jackson",
      "email" : "marcus.jackson@gmail.com",
      "password" : "123456"
    }
    ```
    
### Login
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

### User Body Measurements

#### Saving
  - Post: 

#### Listing
  - Get: 

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
