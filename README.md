# Interview Prep for CJ

## Rationale
This is to make your interview process less stressful by giving you an idea:

- what to expect from an interview
- what we are looking for, so you have a chance to decide if you are a good fit before coming in
- what skills will be tested, to help ensure you are ready for our coding exercise

## Things not to do
- When your interview is scheduled, if there is any reason you are not able to accurately represent your skill set, do not try to get through the interview anyways.  It is far better for us and you if you ask to reschedule the interview.
- For those familiar with JavaScript, don't assume Prototypal inheritance is representative of object oriented programming.  Do a bit of research before the interview so we can be sure we are speaking the same language.

## About Us
Before interviewing with us, try to make sure we are a good fit for you.
This list should help you understand what sets us apart from other companies.
If you don't understand anything on this list, have questions ready for your interviewer.
We are not for everybody, and that's okay.

- We have business decisions made by business people, and technical decisions made by technical people.  While we are accountable to fulfill business needs, business does not dictate our programming languages, tooling, technology choices, or even how we spend our time.
It is common for engineers to solve technical annoyances on our own. 
- Our continuous deployment is now twice a week, Mondays and Wednesdays.
This means that if you push code on Tuesday, it will be live, in production, on Wednesday.
If you push code on Wednesday, it will go live the following Monday.
While some companies do better than us in this regard, we are moving to daily deployment, and eventually true continuous deployment, where every commit automatically makes its way to production.
- We do full lifecycle (full-stack) software development, so expect to be involved in every aspect of software engineering, from gui, to database, to requirements analysis, to helping choose which technology to use.
This does not mean you have to be an expert in everything, most of us are only an expert in one, sometimes two areas.
It does mean that you will be brought up to speed with a basic competence in all aspects of software engineering.
You will always have help when dealing with areas you are less familiar with.
- We have an automated Quality Assurance department.
Another way of saying this is that we don't have a QA department.
Whenever you implement a feature, you are expected to write an automated test that reliably verifies that the feature has not become broken.
This is not as hard as it may sound, and we have plenty of skilled people here that can show you how to write reliable tests efficiently.
We also practice "Test Driven Design", wherein the primary function of tests is how they affect the design of the code, and verifying correctness is an important, but secondary concern.
- We have a sustainable pace.
Overtime here is rare, and any time we detect it happening we take steps to fix our process, rather than trying to squeeze out more productivity with more time.
- We practice agile software development.
Check out the [Agile Manifesto](http://agilemanifesto.org/).
It is also worth looking into agile methodologies, such as Scrum, eXtreme Programming, and Kanban.
- We practice pair programming.
We realize some may have had bad experiences with this, but we practice it in a sustainable way.
However, if you disagree with the very concept of pair programming, even when practiced correctly, you won't be happy here.

Remember this will be a 2-way conversation, so feel free to ask your interview questions about any of this.

## Design Exercise
- You will be given an exercise to see how you well you can organize code.  Functional or Object Oriented, your choice, but make sure you are able to explain the reasoning behind your decisions.

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
