# Side effect testing
There are many ways to test side effecting code.
One way is to create a stub that records the side effect for the test to check.
Here are some examples

## Java
```
import java.io.*;
import java.util.*;

class Solution {
    interface Recorder {
        void recordEvent(String event);
    }
    static class StubRecorder implements Recorder {
        List<String> recordedEvents = new ArrayList<String>();
        public void recordEvent(String event) {
            recordedEvents.add(event);
        }
    }
    public static void main(String[] args) {
        // given
        StubRecorder recorder = new StubRecorder();
        String event = "the event";

        // when
        recorder.recordEvent(event);

        // then
        assertEquals("the event was recorded",
                     recorder.recordedEvents.get(0), 
                     "the event");
    }
    static void assertEquals(String testName, String actual, String expected){
        if(actual.equals(expected)) {
            System.out.println(String.format("PASSED: '%s'", testName));
        } else {
            System.out.println(String.format(
              "FAILED: '%s', expected '%s', got '%s'",
              testName, expected, actual));
        }
    }
}
```

## Haskell
```
{-# LANGUAGE TypeSynonymInstances #-}
{-# LANGUAGE FlexibleInstances #-}
import Control.Monad.Writer

(===) :: (Eq a, Show a) => a -> a -> IO ()
(===) a1 a2 = 
    if (a1 == a2) 
    then print $ "PASSED: " ++ show a1 ++ " is equal to " ++ show a2
    else print $ "FAILED: " ++ show a1 ++ " is not equal to " ++ show a2

infixl 1 ===

main :: IO ()
main = expected === actual
  where
    expected = ["the event"]
    ((), actual) = runWriter $ program event
    event = "the event"

program :: (Recorder m) => String -> m ()
program event = record event


class Recorder m where
  record :: String -> m ()

instance Recorder (Writer [String]) where
  record s = tell [s]
```
