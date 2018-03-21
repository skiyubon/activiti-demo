import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Test.class})
@EnableAutoConfiguration()
@ComponentScan("com.sk")
public class Test {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @org.junit.Test
    public void TestStartProcess() {
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.addClasspathResource("user.bpmn").deploy();

        Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", "John Doe");
        variables.put("email", "john.doe@activiti.com");
        variables.put("phoneNumber", "123456789");
        runtimeService.startProcessInstanceByKey("myProcess", variables);
    }
}
