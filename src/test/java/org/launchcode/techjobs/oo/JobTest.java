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



    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        // Arrange
        String lineSep = System.lineSeparator();
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Act
        String jobString = job.toString();

        //Assert
        assertTrue(jobString.startsWith(lineSep));
        assertTrue(jobString.endsWith(lineSep));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        // Arrange
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Act
        String jobString = job.toString();

        // Assert
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: " + job.getName()));
        assertTrue(jobString.contains("Employer: " + job.getEmployer()));
        assertTrue(jobString.contains("Location: " + job.getLocation()));
        assertTrue(jobString.contains("Position Type: " + job.getPositionType()));
        assertTrue(jobString.contains("Core Competency: " + job.getCoreCompetency()));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        // Arrange
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        // Act
        String jobString = job.toString();

        // Assert
        assertTrue(jobString.contains("ID: "));
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available" ));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }

    @Test
    public void testToStringHandlesIdOnly() {
        // Arrange
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        job.setName(null);
        job.setEmployer(null);
        job.setLocation(null);
        job.setPositionType(null);
        job.setCoreCompetency(null);

        // Act
        String jobString = job.toString();

        // Assert
        assertEquals("OOPS! This job does not seem to exist.", jobString);
    }

}


