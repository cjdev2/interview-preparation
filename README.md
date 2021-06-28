# Interview Preparation for CJ

For Bengaluru candidates, also [see here](bengaluru.md)

## Rationale
This is to make your interview process less stressful by giving you an idea:

- What to expect from an interview.
- What we are looking for, so you have a chance to decide if you are a good fit before coming in.
- What skills will be tested, to help ensure you are ready for our coding exercise.

## To succeed in our interview process
- Read this whole document.  It was written by people who have been on both sides of this interview process, so we know what we are talking about when we recommend what you focus on. 
- Balance initiative and attentiveness.
  It should not be effort on our part to get you to showcase your skill set,
  but don't be so eager that it becomes clear you did not pay attention to what we were asking for.
- Test drive your code.
  We don't care how experienced you are with test driven design as long as you demonstrate you can pick it up.
  If you can't keep separate the red/green/refactor phases in the roman numeral example at the bottom of this document, you are not ready.
- Make sure you understand how to practically apply abstraction in code. For a concrete example of applying abstraction,
  search the web for "Replace conditional with polymorphism". Take the
  contrived [AbstractionSample](/src/main/java/com/cj/interview/preparation/AbstractionSample.java) for instance. When
  presented with something like [TimePeriodsA](/src/main/java/com/cj/interview/preparation/TimePeriodsA.java), you
  should be able to notice the structural duplication in the switch statements, and introduce the proper abstractions.
  One of many possible ways to do this is demonstrated
  in [TimePeriodsB](/src/main/java/com/cj/interview/preparation/TimePeriodsB.java),
- When your interview is scheduled,
  if there is any reason you are not able to accurately represent your skill set,
  do not try to get through the interview anyways.
  It is better for us and you if you ask to reschedule the interview.
- If you have any questions or concerns regarding the "About Us" section of this document,
  be ready to ask them during the interview.

## About Us
Before interviewing with us, try to make sure we are a good fit for you.
This list should help you understand what sets us apart from other companies.
If you don't understand anything on this list, have questions ready for your interviewer.
We are not for everybody.

- We have business decisions made by business people, and technical decisions made by technical people.  While we are accountable to fulfill business needs, business does not dictate our programming languages, tooling, technology choices, or even how we spend our time.
It is common for engineers to solve technical annoyances on our own.
- Our continuous deployment is now twice a week, Mondays and Wednesdays.
This means that if you push code on Tuesday, it will be live, in production, on Wednesday.
If you push code on Wednesday, it will go live the following Monday.
While some companies do better than us in this regard, we are moving to daily deployment, and eventually true continuous deployment, where every commit automatically makes its way to production.
- We do full lifecycle (full-stack) software development, so expect to be involved in every aspect of software engineering, from front end, to database, to requirements analysis, to helping choose which technology to use.
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
We find that the highest quality code is produced by close collaboration, so we practice pair programming every day.
We are one of the rare companies that practices pair programming in an engaging and productive way.
- We are always improving our code, even our oldest code monolith benefits from constant review and refactoring.
Our newer code embraces domain separation and maintainability.

If this sounds exciting to you, you can view our open job listings [here](https://engineering.cj.com/join).

Remember this will be a 2-way conversation, so feel free to ask your interviewer questions about any of this.

## What to expect from our interviews

### Web screen
- Test driven design and implementation of a small set of requirements.
    - What we are looking for
        - Not implementing things there is no requirement for.
        - Minimally implementing features one at a time.
        - Being able to operate in red/green/refactor style.
        - Understanding of design principles.
    - Coderpad
        - You will choose a [coderpad supported programming language](https://coderpad.io/languages).
        - Be sure you know how write tests, and create either [fakes, stubs, or mocks](https://martinfowler.com/articles/mocksArentStubs.html) in that programming language
        - Practice writing tests with the [coderpad](https://coderpad.io/sandbox) sandbox
            - See [examples](coderpad-testing.md) of how to write tests in coderpad
            - Be sure you also know how to test [side effects](side-effect-testing.md)  
        - Try creating a test driven solution to this "time string" example in under an hour: 
            - Input: a bunch of times, minutes and seconds, formatted as a single string like: "12:32 34:01 15:23 9:27 55:22 25:56"
            - Output: the sum of the times, hours, minutes, and seconds, formatted as a single string like: "2:32:41"
            - The answer: [Spoiler alert, try it yourself before clicking this link](https://www.youtube.com/watch?v=WQn5EHpa6Wg)
    - Be able to unit test both state changes and side effects
        - For example, if you log something, you will need to test that the correct thing is logged without relying on a logging framework.

### In person interview
- Evaluating an existing design
    - This is to see how well you can understand design.
    - Be sure you can explain the advantages and disadvantages of a particular design, as well as name the underlying principles at work.
- Maintaining existing code
    - Make sure you understand how to practically apply abstraction in code
    - For a concrete example of applying abstraction, search the web for "Replace conditional with polymorphism"
    - You will have a pairing partner to help keep you on track regarding the red/green/refactor style of programming
    - Design decisions will be left up to you to either justify or change as appropriate 
    - You won't necessarily know the programming language for this exercise, but you will have a pairing partner
        - Understands everything about the language and libraries
        - If you can precisely articulate your intent, your pairing partner can help you with the syntax
        - Can explain anything about how the code is
        - Sometimes gets stuck on design decisions, you will have to take the lead on this

## You need to be very comfortable with coding
The goal for the initial coding exercise is for us to experience what it is like to code with you.
This will be difficult if you are spending most of your time fumbling over language syntax.
Get lots of practice programming, and make sure you can quickly code simple problems.
Stick to things small enough that you can code them in their entirety in one sitting.
Avoid relying on libraries and frameworks, you need to understand how to do it yourself first.
Don't underestimate how fast skills are lost if you don't program every day.
In spite of having a lot of knowledge and experience, people can still perform terribly on the coding exercise because they are rusty.
Don't schedule an interview with us until you are confident you can accurately showcase your skills.

## Foundational Principles
Make sure you understand the foundational theory behind the following:
- Object Oriented Programming
- Functional Programming
- Agile Software Development

For each of these, having a deep understanding of the basics is more important than encyclopedic knowledge.
Make sure you can precisely and accurately describe the fundamental concepts of each topic and are able to recognize how they apply to code you encounter.

We are also interested in your opinions regarding clean, well crafted, code.

## Test Driven Design
This [RomanNumeralTest](src/main/java/com/cj/interview/preparation/RomanNumeralTest.java) example in Java illustrates a style of unit testing commonly called "red/green/refactor".
Make sure you can follow this step by step introduction in your preferred programming language:
- [1 red](src/main/java/com/cj/interview/preparation/RomanNumeralTestA_1_red.java) - design what the function looks like in terms of how it is tested
- [1 green](src/main/java/com/cj/interview/preparation/RomanNumeralTestB_1_green.java) - hard-code the correct answer 
- [1 refactor](src/main/java/com/cj/interview/preparation/RomanNumeralTestC_1_refactor.java) - make it easier to add new tests
- [2 red](src/main/java/com/cj/interview/preparation/RomanNumeralTestD_2_red.java) - prove the hard-coded answer doesn't cut it by adding a second test
- [2 green](src/main/java/com/cj/interview/preparation/RomanNumeralTestE_2_green.java) - implement just enough logic to get the test passing
- [3 red](src/main/java/com/cj/interview/preparation/RomanNumeralTestF_3_red.java) - expose the next missing functionality with a test
- [3 green](src/main/java/com/cj/interview/preparation/RomanNumeralTestG_3_green.java) - implement just enough logic to get the test passing
- [3 refactor](src/main/java/com/cj/interview/preparation/RomanNumeralTestH_3_refactor.java) - we have duplication now, so refactor it
- [4 red](src/main/java/com/cj/interview/preparation/RomanNumeralTestI_4_red.java) - expose the next missing functionality with a test
- [4 green](src/main/java/com/cj/interview/preparation/RomanNumeralTestJ_4_green.java) - implement just enough logic to get the test passing

And then make sure you can continue this pattern in your preferred programming language until you end up with something simple and well tested like [RomanNumeralTest](src/main/java/com/cj/interview/preparation/RomanNumeralTest.java). 

Once you are comfortable with the roman numeral example, try your hand at the aforementioned "time string" example, and see how the test driven approach changes your design.
