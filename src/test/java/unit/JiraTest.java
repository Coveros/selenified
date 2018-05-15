package unit;

import com.coveros.selenified.utilities.Jira;
import com.coveros.selenified.utilities.jira.Annotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class JiraTest {

    @Test
    public void verifyDefaultTest(Method method) {
        Assert.assertFalse(new Annotation(method).isAnnotationPresent());
        Assert.assertFalse(new Annotation(method).isProjectPresent());
        Assert.assertFalse(new Annotation(method).isIssuePresent());
    }

    @Test
    @Jira
    public void verifyProjectTest(Method method) {
        Assert.assertTrue(new Annotation(method).isAnnotationPresent());
        Assert.assertFalse(new Annotation(method).isProjectPresent());
        Assert.assertNull(new Annotation(method).getProject());
    }

    @Test
    @Jira(project = "HW")
    public void verifySetProjectTest(Method method) {
        Assert.assertTrue(new Annotation(method).isAnnotationPresent());
        Assert.assertTrue(new Annotation(method).isProjectPresent());
        Assert.assertEquals(new Annotation(method).getProject(), "HW");
    }

    @Test
    @Jira
    public void verifyIssueTest(Method method) {
        Assert.assertTrue(new Annotation(method).isAnnotationPresent());
        Assert.assertFalse(new Annotation(method).isIssuePresent());
        Assert.assertNull(new Annotation(method).getIssue());
    }

    @Test
    @Jira(issue = "HW-123456")
    public void verifySetIssueTest(Method method) {
        Assert.assertTrue(new Annotation(method).isAnnotationPresent());
        Assert.assertTrue(new Annotation(method).isIssuePresent());
        Assert.assertEquals(new Annotation(method).getIssue(), "HW-123456");
    }

    @Test
    @Jira(project = "HW", issue = "HW-123456")
    public void verifySetProjectAndIssueTest(Method method) {
        Assert.assertTrue(new Annotation(method).isAnnotationPresent());
        Assert.assertTrue(new Annotation(method).isProjectPresent());
        Assert.assertTrue(new Annotation(method).isIssuePresent());
        Assert.assertEquals(new Annotation(method).getProject(), "HW");
        Assert.assertEquals(new Annotation(method).getIssue(), "HW-123456");
    }
}