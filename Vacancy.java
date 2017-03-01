package groupProject;

/* List in TXT file:
 * [0] vacancyID;
 * [1] jobTitle;
 * [2] fieldOfStudy;
 * [3] requiredExperience;
 * [4] preferedAvailability;
 * [5] Dutch;
 * [6] English;
 * [7] German;
 * [8] French;
 * [9] MS Office;
 * [10] Javascript;
 * [11] Sales;
 * [12] Management
 */

public class Vacancy {
	int vacancyID;
	String jobTitle;
	char fieldOfStudy;
	int requiredExperience;
	boolean preferredAvailability;

	boolean[] vacancyLanguages = new boolean[4]; 

	boolean[] vacancySkills = new boolean[4];
}
