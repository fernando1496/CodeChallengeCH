# Clipboard health code challenge for SDET

Contents of this file
---------------------

* Dependencies
* Important note
* Project description
* How to Run UI/E2E Test Execution as Maven project from IDE
* How to Run UI Test Execution from CMD
* CI/CD with circleCI
* Make a pull request process
* Clone a repository
* Project execution guide

---

## Dependencies:
 - Maven
 - Java
 - TestNG
 - Surefire
 - Driver manager
 - log4j-core
 - log4j-api
 - Selenium
 - Extent reports

---

## Important note
1. Thread.sleep() should NEVER be used in projects, I only added them for demo purposes.
2. Extent report was implemented, mock classes: `MockFailTest` and `MockPassTest` were included to demo the implementation of extent report manager and listeners.
3. Extent report execution report is in `CodeChallengeCH/UITests/extent-reports`




---

## Project description

This is a multi-module project that can support future API tests integration,
it covers a basic but dynamic workflow in Amazon. This is a code challenge for Clipboard Health SDET position.

---

## To Run UI/E2E Test Execution as Maven project from IDE
1. Create Run configuration:
   1. Select `Maven` template
   2. put under Working Directory path to : `UITests`
   3. put under Command line:  `test`
   4. put under Profiles: `-api` (Only if API module is in project)
   
2. Select created configuration and click `Run` button from IDE.

---

## To Run UI Test Execution from CMD
`mvn test`

---

## CI/CD with circleCI
CircleCI yml file was included in the project so if the repository is downloaded and inetgrated with circleCi it should run.

---



## Make a pull request process

1. git checkout -b "<taskName>"   <= create a new branch before making any changes. note: branch name is the task you are working on.
2. Make changes to code (e.g.: add new files, refactoring, etc.)
3. git add *                      <= add all changes to stage
4. git commit -m "<description of the done work>"
5. git checkout master
6. git pull --rebase              <= this will grabbed all latest changes from master
7. git checkout <taskName>        <= switch back to your working branch
8. git rebase master              <= grab latest change from master and put them into your branch and put your changes on the top of the commit tree
9. git push                       <= should push everything to remote
10. Go to Github and check if the Pull request was create (if not, then create on and assign it to me)
11. Wait for approval
12. After approval and merge your local branch can be deleted if task accomplished.
13. For the next task create new branch.

---

## Clone a repository

Use these steps to clone from SourceTree, our client for using the repository command-line free. Cloning allows you to work on your files locally. If you don't yet have SourceTree, [download and install first](https://www.sourcetreeapp.com/). If you prefer to clone from the command line, see [Clone a repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository).

1. You’ll see the clone button under the **Source** heading. Click that button.
2. Now click **Check out in SourceTree**. You may need to create a SourceTree account or log in.
3. When you see the **Clone New** dialog in SourceTree, update the destination path and name if you’d like to and then click **Clone**.
4. Open the directory you just created to see your repository’s files.

Now that you're more familiar with your repository, go ahead and add a new file locally. You can [push your change back to github with SourceTree](https://docs.github.com/en/get-started/importing-your-projects-to-github/importing-source-code-to-github/adding-locally-hosted-code-to-github), or you can [add, commit,](https://docs.github.com/en/get-started/importing-your-projects-to-github/importing-source-code-to-github/adding-locally-hosted-code-to-github) and [push from the command line](https://docs.github.com/en/get-started/importing-your-projects-to-github/importing-source-code-to-github/adding-locally-hosted-code-to-github).

---

Project execution guide
-------------
The project helps keeping a high quality product, therefore the objectives of having an automation framework are the following:

* Ensure that the features of the website are working as expected.
* Ensure that nothing affected in a negative way after a deployment.
* Provide stakeholders with rapid and accurate feedback in the status of the product.
* Ensure that the endpoints are working properly.

In order to fulfill these objectives, the automation framework need to be executed as described below:
* API regression tests must be executed 2 times a day to verify endpoints status.
* UI and API regression tests must be executed after a big deployment to the environments.
* UI regression tests must be executed before publishing the application.
* UI smoke tests must be executed after doing a change to a feature that may affect other features(I.E: left menu).

After every execution reports will be created, they must be published and shared with the stakeholders and team working
in th project.

In the case of a test failure, the test must be run isolated to verify if it was a flaky test or a bug
in the application. Data will be provided by the logs and the reports that are generated after every execution.
