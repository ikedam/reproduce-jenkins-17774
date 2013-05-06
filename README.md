reproduce-jenkins-17774
=======================

Empty Jenkins plugin containing a test to reproduce [JENKINS-17774] (https://issues.jenkins-ci.org/browse/JENKINS-17774)

How to reproduce JENKINS-17774
------------------------------

1. Run on Windows (Maybe reproducible only on Windows Vista or later)
2. Install [TortoiseGit] (http://code.google.com/p/tortoisegit/).
3. Enable Icon Overlays on TortoiseGit.
	* Open Settings > Icon Overlays, check Default in Status cache.
4. Clone this repository.
5. Create "work" directory in the cloned repository.
	* mkdir work
	* This is also created by running mvn "hpi:run".
	* Without work directory, "mvn test" uses %LOCALAPPDATA%\temp (maybe %temp% or %tmp%), and Jenkins-17774 does not happen. This may be affected by TortoiseGit's cache behaviour.
6. Run mvn test.


How to test JENKINS-17774 is fixed
----------------------------------

1. Uncomment the dependencies block in pom.xml.
	* This makes this project to use jenkins-test-harness.jar built from https://github.com/ikedam/jenkins/tree/feature/JENKINS-17774.
2. Run mvn test.

