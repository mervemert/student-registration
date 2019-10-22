package tr.com.example.student.registration.validator;


import tr.com.example.student.registration.entity.Student;
import tr.com.example.student.registration.service.StudentService;
import tr.com.example.student.registration.util.SpringUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Optional;

/*ne
    validate for studentId whether or not unique
 */
@FacesValidator("studentIdValidator")
public class StudentIdValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        //get field coming from xhtml page
        Long studentId = (Long) object;
        String id = (String) uiComponent.getAttributes().get("studentId");

        StudentService studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        Optional<Student> student = studentService.findByStudentId(studentId);

        if (student.isPresent()) {
            if (id == null)
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student Id is already exist", null));
        }
    }

}
