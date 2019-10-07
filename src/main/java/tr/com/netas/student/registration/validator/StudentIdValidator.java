package tr.com.netas.student.registration.validator;


import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.service.StudentService;
import tr.com.netas.student.registration.util.SpringUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Optional;

@FacesValidator("studentIdValidator")
public class StudentIdValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String studentId = (String) object;
        String id = (String) uiComponent.getAttributes().get("studentId");

        StudentService studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        Optional<Student> student = studentService.findByStudentId(studentId);

        if (student.isPresent()) {
            if (id == null)
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error.duplicate.student.id", null));
        }
    }

}
