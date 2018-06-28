# Testing in coderpad
This document shows how to write tests in coderpad for various languages.

## C
```
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

void assertTrue(char* message, bool x) {
  if(x) {
    printf("SUCCESS: %s\n", message);
  } else {
    printf("FAILURE: %s, expected to be true\n", message);
  }
}

void assertIntEqual(char* message, int actual, int expected) {
  if(actual == expected) {
    printf("SUCCESS: %s\n", message);
  } else {
    printf("FAILURE: %s, expected %d, but got %d\n", message, expected, actual);
  }
}

void assertStringEqual(char* message, char* actual, char* expected) {
  if(strcmp(actual, expected) == 0) {
    printf("SUCCESS: %s\n", message);
  } else {
    printf("FAILURE: %s, expected %s, but got %s\n", message, expected, actual);
  }
}

int main() {
  assertTrue("check boolean", true);
  assertIntEqual("compare numbers", 2, 2);
  assertStringEqual("compare strings", "abc", "abc");
}
```

## C++
```
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include <vector>
#include <string>

TEST_CASE( "check boolean", "[assertions]" ) {
    REQUIRE( true );
}

TEST_CASE( "compare numbers", "[assertions]" ) {
    REQUIRE( 2 == 2 );
}

TEST_CASE( "compare strings", "[assertions]" ) {
  std::string a = "abc";
  std::string b = "abc";
  REQUIRE( a == b );
}

TEST_CASE( "compare lists", "[assertions]" ) {
  std::vector<int> a;
  a.push_back(1);
  a.push_back(2);
  a.push_back(3);
  std::vector<int> b;
  b.push_back(1);
  b.push_back(2);
  b.push_back(3);
  REQUIRE( a == b);
}
```

## C#
```
using NUnit.Framework;
using NUnitLite;
using System;
using System.Reflection;

public class Runner {
    public static int Main(string[] args) {
        return new AutoRun(Assembly.GetCallingAssembly()).Execute(new String[] {"--labels=All"});
    }

    [TestFixture]
    public class Foo {
        [Test]
        public void TestCheckBoolean() {
            Assert.IsTrue(true);
        }

        [Test]
        public void TestCompareNumbers() {
            Assert.AreEqual(2,2);
        }

        [Test]
        public void TestCompareStrings() {
            Assert.AreEqual("abc","abc");
        }

        [Test]
        public void TestCompareLists() {
            Assert.AreEqual(new int[]{1,2,3}, new int[]{1,2,3});
        }
    }
}
```

## Clojure
```
(require 'clojure.test)

;; check boolean
(clojure.test/is true)

;; compare integers
(clojure.test/is (= 2 2))

;; compare strings
(clojure.test/is (= "abc" "abc"))

;; compare lists
(clojure.test/is (= (list 1 2 3) (list 1 2 3)))
```

## CoffeeScript (chai)
```
chai = require('chai')
sinon = require('sinon')
sinonChai = require('sinon-chai')

chai.assert.ok(true, 'check boolean');
chai.assert.equal(2, 2, 'compare numbers');
chai.assert.equal('abc', 'abc', 'compare strings');
chai.assert.deepEqual([1,2,3], [1,2,3], 'compare arrays');
```

## CoffeeScript (mocha)
```
Mocha = require('mocha')
assert = require('assert')
mocha = new Mocha()

mocha.suite.emit('pre-require', this, 'solution', mocha)

describe('Test suite', () ->
  it('check boolean', () ->
    assert.ok(true)
  )
  it('compare numbers', () ->
    assert.equal(2,2)
  )
  it('compare strings', () ->
    assert.equal('abc','abc')
  )
  it('compare arrays', () ->
    assert.deepEqual([1,2,3],[1,2,3]);
  )
)

mocha.run()
```

## Elixir
```
ExUnit.start()
defmodule TimeConversionTest do
  use ExUnit.Case
  test "check boolean" do
    assert true
  end
  test "compare numbers" do
    assert 2 == 2
  end
  test "compare strings" do
    assert "abc" == "abc"
  end
  test "compare lists" do
    assert [1,2,3] == [1,2,3]
  end
end
```

## Erlang
```
-module(solution).
-export([start/0]).
-include_lib("eunit/include/eunit.hrl").

fib_test_() ->
   [?_assert(true),                 % check boolean
    ?_assert(2 =:= 2),              % compare numbers
    ?_assert("abc" =:= "abc"),      % compare strings
    ?_assert([1,2,3] =:= [1,2,3])   % compare lists
   ].

start() -> test().
```

## F#
```
module Solution

open NUnitLite
open NUnit.Framework

open System
open System.Reflection

[<Test>]
let checkBoolean() = Assert.IsTrue(true)

[<Test>]
let compareNumbers() = Assert.AreEqual(2,2)

[<Test>]
let compareStrings() = Assert.AreEqual("abc", "abc")

[<Test>]
let compareLists() = Assert.AreEqual([1,2,3],[1,2,3])

[<EntryPoint>]
let main argv =
    (new AutoRun(Assembly.GetCallingAssembly())).Execute( [| "--labels=All" |])
```

## Go
```
package main

import "fmt"

func main() {
  runTests();
}

func runTests(){
  testBoolean();
  testNumbers();
  testStrings();
  testLists();
  fmt.Println("ALL TESTS SUCCEEDED");
}

func testBoolean() {
  assertTrue(true, "test boolean");
}

func testNumbers() {
  assertEquals(2,2);
}

func testStrings() {
  assertEquals("abc","abc");
}

func testLists() {
  assertListEquals([]int{1,2,3}, []int{1,2,3});
}

func assertTrue(actual bool, message string) {
  if actual != true {
    panic(fmt.Sprintf("FAILURE: %s", message))
  }
}

func assertListEquals(expected interface{}, actual interface{}){
  assertEquals(fmt.Sprintf("%#v", expected), fmt.Sprintf("%#v", actual))
}

func assertEquals(expected interface{}, actual interface{}) {
  if expected != actual {
    panic(fmt.Sprintf("FAILURE: %v does not equal %v", expected, actual))
  }
}
```

## Haskell
```
main = tests

tests = do
  assertTrue "this boolean is true" True
  assertEquals "strings are equal" "abc" "abc"
  assertEquals "numbers are equal" 123 123
  assertEquals "lists are equal" [1, 2, 3] [1, 2, 3]

assertTrue :: String -> Bool -> IO ()
assertTrue msg a =
  if a
  then print ("SUCCESS: " ++ msg)
  else print ("FAILURE: " ++ msg)

assertEquals :: Eq a => String -> a -> a -> IO ()
assertEquals msg a1 a2 =
  if a1 == a2
  then print ("SUCCESS: " ++ msg)
  else print ("FAILURE: " ++ msg)
```

## Java
```
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import org.junit.runner.*;

public class Solution {
    @Test
    public void testCheckBoolean() {
      Assert.assertTrue(true);
    }

   @Test
    public void testCompareNumbers() {
      Assert.assertEquals(2,2);
    }

    @Test
    public void testCompareStrings() {
      Assert.assertEquals("abc", "abc");
    }
   
    @Test
    public void testCompareLists() {
      Assert.assertEquals(Arrays.asList(new Integer[]{1,2,3}), Arrays.asList(new Integer[]{1,2,3}));
    }
   

    public static void main(String[] args) {
      JUnitCore.main("Solution");
    }
}
```

## JavaScript (chai)
```
var chai = require('chai')
var sinon = require('sinon')
var sinonChai = require('sinon-chai')

chai.assert.ok(true, 'check boolean');
chai.assert.equal(2, 2, 'compare numbers');
chai.assert.equal('abc', 'abc', 'compare strings');
chai.assert.deepEqual([1,2,3], [1,2,3], 'compare arrays');
```

## JavaScript (mocha)
```
var Mocha = require('mocha')
var assert = require('assert')
var mocha = new Mocha()

mocha.suite.emit('pre-require', this, 'solution', mocha)

describe('Test suite', function() {
  it('check boolean', function() {
    assert.ok(true);
  })
  it('compare numbers', function() {
    assert.equal(2,2);
  })
  it('compare strings', function() {
    assert.equal('abc','abc');
  })
  it('compare arrays', function() {
    assert.deepEqual([1,2,3],[1,2,3]);
  })
})

mocha.run()
```

## Kotlin
```
import org.junit.*;
import org.junit.runner.*;

fun main(args: Array<String>) {
  JUnitCore.main("Solution");
}

 class Solution {
   @Test
   fun testBoolean() {
     Assert.assertTrue(true);
   }

   @Test
   fun testNumbers() {
     Assert.assertEquals(2,2);
   }

   @Test
   fun testStrings() {
     Assert.assertEquals("abc","abc");
   }

   @Test
   fun testCompareLists() {
     Assert.assertEquals(listOf(1,2,3), listOf(1,2,3));
   }
}
```
## Objective-C
```
#import <Foundation/Foundation.h>
#import <stdio.h>

const char* assertTrue(NSString* message, BOOL actual){
  NSString* result;
  if(actual) {
    result = [[NSString alloc] initWithFormat:@"SUCCESS: %@\n",message];
  } else {
    result = [[NSString alloc] initWithFormat:@"FAILURE: %@, expected to be true\n",message];
  }
  return [result UTF8String];
}

const char* assertIntEqual(NSString* message, int actual, int expected){
  NSString* result;
  if(actual == expected) {
    result = [[NSString alloc] initWithFormat:@"SUCCESS: %@\n",message];
  } else {
    result = [[NSString alloc] initWithFormat:@"FAILURE: %@, expected %d, got %d\n",message, expected, actual];
  }
  return [result UTF8String];
}

const char* assertStringEqual(NSString* message, NSString* actual, NSString* expected){
  NSString* result;
  if(actual == expected) {
    result = [[NSString alloc] initWithFormat:@"SUCCESS: %@\n",message];
  } else {
    result = [[NSString alloc] initWithFormat:@"FAILURE: %@, expected %@, got %@\n",message, expected, actual];
  }
  return [result UTF8String];
}


int main (int argc, const char * argv[])
{
  printf("%s", assertTrue(@"check boolean", true));
  printf("%s", assertIntEqual(@"compare numbers", 2, 2));
  printf("%s", assertStringEqual(@"compare strings", @"abc", @"abc"));
}
```

## OCaml
```
let assertTrue = fun message x -> 
  if x 
  then (String.concat "" ["SUCCESS: "; message])
  else (String.concat "" ["FAILURE: "; message; ", expected to be true"]) 

let assertIntEquals = fun message x y -> 
  if x = y
  then (String.concat "" ["SUCCESS: "; message])
  else (String.concat "" ["FAILURE: "; message; ", expected "; (string_of_int y); ", got "; (string_of_int x)]);;

let assertStringEquals = fun message x y -> 
  if x = y
  then (String.concat "" ["SUCCESS: "; message])
  else (String.concat "" ["FAILURE: "; message; ", expected "; y; ", got "; x]);;

let intListToString = fun list -> (String.concat " " (List.map string_of_int list))

let assertIntListEquals = fun message x y -> 
  if x = y
  then (String.concat "" ["SUCCESS: "; message])
  else (String.concat "" ["FAILURE: "; message; ", expected "; (intListToString x); ", got "; (intListToString y)]);;

 
print_endline (assertTrue "check boolean" true);;
print_endline (assertIntEquals "compare numbers" 2 2);;
print_endline (assertStringEquals "compare strings" "abc" "abc");;
print_endline (assertIntListEquals "compare lists" [1;2;3] [1;2;3]);;

```

## Perl
```
use strict;
use warnings;
use Data::Dumper;
use Test;

BEGIN { plan tests => 3 }

# check boolean
ok(1);

ok(2, 2, "compare numbers");

ok("abc", "abc", "compare strings");

ok((1,2,3), (1,2,3), "compare arrays");

## PHP
<?php

function assertTrue($message, $boolean) : String
{
    if($boolean) {
      return "SUCCESS: $message\n";
    } else {
      return "FAILURE: $message\n";
    }
}

function assertEqual($message, $actual, $expected) : String
{
  $actualString = json_encode($actual);
  $expectedString = json_encode($expected);
  if($actual == $expected) {
    return "SUCCESS: {$message}\n";
  } else {
    return "FAILURE: $message, expected $expectedString, got $actualString\n";
  }
}

echo assertTrue("check boolean", true);
echo assertEqual("compare numbers", 2, 2);
echo assertEqual("compare strings", "abc", "abc");
echo assertEqual("compare arrays", array(1,2,3), array(1,2,3));

?>
```

## Python (unittest)
```
import unittest

class TestSamples(unittest.TestCase):
    def test_check_boolean(self):
        self.assertTrue(True)

    def test_compare_numbers(self):
        self.assertEqual(2,2)

    def test_compare_strings(self):
        self.assertEqual("abc", "abc")

    def test_compare_arrays(self):
        self.assertEqual([1,2,3],[1,2,3])

unittest.main(exit=False)
```

## Python (pytest)
```
import pytest

def test_check_boolean():
    assert True

def test_compare_numbers():
    assert 2 == 2

def test_compare_strings():
    assert "abc" == "abc"

def test_compare_arrays():
    assert [1,2,3] == [1,2,3]

pytest.main()
```

# R
```
library('testthat')

describe("assertions", {
  it("check boolean", {
    expect_true(TRUE)
  })
  it("compare numbers", {
    expect_equivalent(2,2)
  })
  it("compare strings", {
    expect_equivalent("abc", "abc")
  })
  it("compare lists", {
    expect_equivalent(c(1,2,3),c(1,2,3))
  })
})
```

## Ruby (minitest)
```
require 'minitest/autorun'

describe 'assertions' do
  it 'check boolean' do
    assert(true, 'boolean is true')
  end

  it 'compare numbers' do
    2.must_equal 2
  end

  it 'compare numbers' do
    assert_equal('abc', 'abc', 'strings equal')
  end

  it 'compare numbers' do
    [1,2,3].must_equal [1,2,3]
  end
end
```

## Ruby (rspec)
```
require 'rspec/autorun'

RSpec.describe 'assertions' do
  it 'check boolean' do
    expect(true).to be_truthy 
  end

  it 'compare numbers' do
    expect(2).to eq(2)
  end

  it 'compare numbers' do
    expect('abc').to eq('abc')
  end

  it 'compare numbers' do
    expect([1,2,3]).to eq([1,2,3])
  end
end
```

## Rust
```
fn main() {
  assert!(true, "check boolean");
  assert_eq!(2, 2, "compare numbers");
  assert_eq!("abc", "abc", "compare strings");
  assert_eq!([1,2,3], [1,2,3], "compare lists");
}
```

## Scala
```
import org.scalatest.{FunSuite, Matchers}

class Testable extends FunSuite with Matchers {
  test("check boolean") {
    assert(true, "boolean value is true");
  }

  test("compare numbers") {
    assert(2 === 2);
  }

  test("compare strings") {
    assert("abc" === "abc");
  }

  test("compare lists") {
    assert(Seq(1,2,3) === Seq(1,2,3));
  }
}

object Solution extends App {
  new Testable().execute()
}
```

## Swift
```
import XCTest

class MyTest : XCTestCase {
  static var allTests = {
    return [("checkBoolean", checkBoolean),
           ("compareNumbers", compareNumbers),
           ("compareStrings", compareStrings),
           ("compareLists", compareLists)]
  }()
  func checkBoolean() {
    XCTAssertTrue(true, "check boolean")
  }
  func compareNumbers() {
    XCTAssertEqual(2, 2, "compare numbers")
  }
  func compareStrings() {
    XCTAssertEqual("abc", "abc", "compare strings")
  }
  func compareLists() {
    XCTAssertEqual([1,2,3], [1,2,3], "compare lists")
  }
}

XCTMain([testCase(MyTest.allTests)])
```

## Visual Basic
```
Imports NUnit.Framework
Imports NUnitLite
Imports System
Imports System.Reflection

<TestFixture()>
Public Class TestGroup
    <Test()>
    Public Sub CheckBoolean()
        Assert.IsTrue(true)
    End Sub
    <Test()>
    Public Sub CompareNumbers()
        Assert.AreEqual(2,2)
    End Sub
    <Test()>
    Public Sub CompareStrings()
        Assert.AreEqual("abc", "abc")
    End Sub
    <Test()>
    Public Sub CompareLists()
        Assert.AreEqual({1,2,3},{1,2,3})
    End Sub
End Class

Module Solution
    Sub Main()
        Dim autorunner As New AutoRun(Assembly.GetCallingAssembly())
        autorunner.execute({"--noresult"})
    End Sub
End Module
```