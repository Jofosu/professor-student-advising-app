##The test should pass

##Test might fail if the emulator creates a pop-up (expresso doesn't know how to find and click
fields/buttons when a pop-up shows up).

This is okay if you disable pop-ups or click them away as the test progresses


## It's recommended to run tests by alphabetical order. PoolOptions relies on there
already being a course in the courseCatalogue

## For some test like add advisees, there will be a snackbar error message if you try to add an
advisee that already exist. That is on purpose, but it will cause the test to fail. Try deleting
the things from firebase if that happens.