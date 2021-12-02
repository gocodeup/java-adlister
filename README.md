# Adlister Project

This is the project that we will be going through in the latter part of the Java
curriculum.

This repository contains various
[tags](https://git-scm.com/book/en/v2/Git-Basics-Tagging) that correspond to
each lesson we will cover.

## Setup and Workflow

1. Fork this repository to your GitHub account.

1. Clone this repository.

As we progress through the java lessons, for each exercise you should:

0. Make sure all of your previous work is committed, and your working directory
   is clean.

    ```
    git status
    ```

    This is good practice in general before manipulating a git repository

1. Checkout the corresponding tag

    For example:

    ```
    git checkout servlets
    ```

1. Create and switch to a new branch for your work on the exercise

For example:

    ```
    git branch servlets-exercise
    git checkout servlets-exercise
    ```

    **It is very important that you create and switch to a new branch here, if
    you do not, your work and commits could be lost!**

    At this point, you could merge your previous work into the current branch,
    or start "fresh" from the branch you just created

1. Add and commit as you work your way through the exercise

1. Push your branch

1. (Optionally) Check out the tag containing the solution for the exercise

    All of the tags that correspond to each exercise also have a tag suffixed
    with `-solution`
