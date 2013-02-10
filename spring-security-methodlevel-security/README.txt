###############################################################################
                    Calendar - README FILE
###############################################################################

The Calendar application is part of Packt Publishing's Spring Security 3.1.

===============================================================================
Running the Calendar application
===============================================================================

There are number of ways for running the Calendar application. A summary of the
methods of running the application are discussed below. Detailed instructions
for each method are found in the following sections.

  * Using Maven 3 -       For those that are more familiar with Maven, the
                          application can be ran using Maven 3 and Cargo.
  * Spring Tool Suite -   This is the best way to follow along with the book
                          since editing the files can be done with the benefits
                          of a modern IDE.

All methods assume you have installed JDK 1.6. This includes specifying it on
your PATH, and properly set JAVA_HOME. You can validate that JDK 1.6 is
properly installed by checking the output of running the following from the
command line

    javac -version

You will also need an internet connection to download the dependencies for the
first time.

-------------------------------------------------------------------------------
Using Maven 3
-------------------------------------------------------------------------------

For those that are more familiar with Maven, the application can be ran using
Maven 3 and the Cargo Maven plugin.

1) If you have not done so, download and install Maven 3 from
   http://maven.apache.org/download.html
2) Ensure you have setup your PATH variable so that running the following from
   the command line produces the Maven Version

     mvn --version

2) Ensure you have an internet connection
3) Run the following command within the calendar directory.

     mvn package cargo:run

   NOTE: The first time you run the command, it may take a while as all the
         dependencies will be downloaded.

The application will be available at http://localhost:8080/calendar/

-------------------------------------------------------------------------------
Using Spring Tool Suite (STS)
-------------------------------------------------------------------------------

The best method for following along in the book is by using an IDE. While the
setup for running the project with a standard Eclipse Distribution should be
similar, the focus of this book is on Spring and so we have chosen to use
Spring Tool Suite (STS). If you wish you should be able to modify these
instructions to use Eclipse's J2EE distribution.

1) Download and install Spring Tool Suite (STS) from
   http://www.springsource.org/springsource-tool-suite-download

   NOTE: At the time of this writing there is a form asking for some basic
         information about you. However, you do not need to fill it out if you
         agree to the terms and click the "download page" link.

2) Open STS
3) Select a fresh workspace location for this book. We suggest a folder named
   packtspringsecurity-workspace within your home directory.
4) Import the project as a Maven project.

   a) In STS select File->Import
   b) Select Maven->Existing Maven Projects
   c) Click Browse... for the Root Directory and select the directory
      containing all the source code.

      NOTE: This directory should be the parent directory all the source code.
   d) Click Finish
   e) All of the source code will be imported into your workspace. Each
      chapter's source code will begin with

          chapter<CHAPTER_NUMBER>-<CHECKPOINT_NUMBER>

      For each chapter you should start with chapter<CHAPTER_NUMBER>-00. There
      will be points in the text where you are asked to try to run the
      application. Each of these points will contain full source code for the
      specified chapter and checkpoint.

5) Right click the project and select Run As->Run on Server
6) Select the default selected "VMware vFabric tc Server" and click Finish.

   NOTE: If it asks if you want to use Spring Insight, you may select "No".

7) The application will open in STS. It will also be available from your web
   browser of choice at http://localhost:8080/calendar/
