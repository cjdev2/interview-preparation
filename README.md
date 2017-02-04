# Interview Prep for CJ

## Rationale
This is to make your interview process less stressful by giving you an idea:

- what to expect from an interview
- what we are looking for, so you have a chance to decide if you are a good fit before coming in
- what skills will be tested, to help ensure you are ready for our coding exercise

## Coding exercise
- For the coding exercise, one of us will be pairing with you via [CoderPad](https://coderpad.io)
- Make sure you are comfortable with at least one of CoderPad's supported [languages](https://coderpad.io/languages)
- To check if you are ready, see if you can solve this "time string" example in under an hour: 
    - Input: a bunch of times, minutes and seconds, formatted as a single string like: "12:32 34:01 15:23 9:27 55:22 25:56"
    - Output: the sum of the times, hours, minutes, and seconds, formatted as a single string like: "2:32:41"

## If you are relatively new, or out of practice:

### You need to be very comfortable with coding
The goal for the initial coding exercise is for us to experience what it is like to code with you.
Get lots of practice programming, and make sure you can quickly code simple problems.
Stick to things small enough that you can code them in their entirety in one sitting.
Avoid relying on libraries and frameworks, you need to understand how to do it yourself first.
Don't underestimate how fast skills are lost if you don't program every day.
In spite of having a lot of knowledge and experience, people can still perform terribly on the coding exercise because they are rusty.
Don't schedule an interview with us until you are confident you can accurately showcase your skills.

### Foundational Principles
Make sure you understand the foundational theory behind the following:
- Object Oriented Programming (if you don't know Functional Programming)
    - Be aware that JavaScript's prototype based inheritance is different from the way most languages implement Object Oriented Programming.
- Functional Programming (if you don't know Object Oriented Programming)
- Algorithm Analysis (in particular, Big O notation)
- Data Structures

For each of these, having a deep understanding of the basics is more important than encyclopedic knowledge.
Make sure you can precisely and accurately describe the fundamental concepts of each topic and are able to recognize how they apply to code you encounter.
You don't have to know both Object Oriented Programming and Functional Programming, but you will find it difficult to get through our interview process if you don't know one or the other.

### Test Driven Design
Although we don't currently require that candidates know Test Driven Design before interviewing with us, getting familiar with the concept can help interviews go more smoothly.
This [RomanNumeralTest](src/main/java/com/cj/interview/prep/RomanNumeralTest.java) example in Java illustrates a style of unit testing commonly called "red/green/refactor".
Make sure you can follow this step by step introduction in your preferred programming language:
- [1 red](src/main/java/com/cj/interview/prep/RomanNumeralTestA_1_red.java) - design what the function looks like in terms of how it is tested
- [1 green](src/main/java/com/cj/interview/prep/RomanNumeralTestB_1_green.java) - hard-code the correct answer 
- [1 refactor](src/main/java/com/cj/interview/prep/RomanNumeralTestC_1_refactor.java) - make it easier to add new tests
- [2 red](src/main/java/com/cj/interview/prep/RomanNumeralTestD_2_red.java) - prove the hard-coded answer doesn't cut it by adding a second test
- [2 green](src/main/java/com/cj/interview/prep/RomanNumeralTestE_2_green.java) - implement just enough logic to get the test passing
- [3 red](src/main/java/com/cj/interview/prep/RomanNumeralTestF_3_red.java) - expose the next missing functionality with a test
- [3 green](src/main/java/com/cj/interview/prep/RomanNumeralTestG_3_green.java) - implement just enough logic to get the test passing
- [3 refactor](src/main/java/com/cj/interview/prep/RomanNumeralTestH_3_refactor.java) - we have duplication now, so refactor it
- [4 red](src/main/java/com/cj/interview/prep/RomanNumeralTestI_4_red.java) - expose the next missing functionality with a test
- [4 green](src/main/java/com/cj/interview/prep/RomanNumeralTestJ_4_green.java) - implement just enough logic to get the test passing

And then make sure you can continue this pattern in your preferred programming language until you end up with something simple and well tested like [RomanNumeralTest](src/main/java/com/cj/interview/prep/RomanNumeralTest.java). 

Once you are comfortable with the roman numeral example, try your hand at the aforementioned "time string" example, and see how the test driven approach changes your design.
