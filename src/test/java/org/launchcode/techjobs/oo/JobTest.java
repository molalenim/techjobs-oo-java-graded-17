package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        //Arrange
        String msg = "to verify that the IDs of the two objects are distinct.";
        Job job1 = new Job();
        Job job2 = new Job();

        //Assert
        assertNotEquals(job1.getId(), job2.getId(), msg);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // Arrange
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Assert
        assertTrue(job instanceof Job); // Asserts that job is an instance of Job class
        assertTrue(job.getEmployer() instanceof Employer); // Asserts that employer is an instance of Employer class
        assertTrue(job.getLocation() instanceof Location); // Asserts that location is an instance of Location class
        assertTrue(job.getPositionType() instanceof PositionType); // Asserts that positionType is an instance of PositionType class
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency); // Asserts that coreCompetency is an instance of CoreCompetency class

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        // Arrange
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Act
        boolean result = job1.equals(job2);

        // Assert
        assertFalse(result);
    }


}
