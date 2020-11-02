package org.fabi;

import org.fabi.exceptions.IdNonNullException;
import org.fabi.exceptions.QuestionIdentiqueException;
import org.fabi.exceptions.QuestionTailleMauvaise;
import org.fabi.impl.ServiceImplimentation;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestQuestion
{

    @Test
    public void IdNonNull() throws IdNonNullException, QuestionIdentiqueException, QuestionTailleMauvaise {

        Service service = new ServiceImplimentation();
        service.ajoutQuestion(new VDQuestion(2, "Allo?"));
    }
    @Test
    public void TailleQuestionTropCourte() throws QuestionTailleMauvaise, QuestionIdentiqueException, IdNonNullException {
        Service service = new ServiceImplimentation();
        service.ajoutQuestion(new VDQuestion(1, "allo"));
    }
    @Test
    public void TailleQuestionTropLongue() throws QuestionTailleMauvaise, QuestionIdentiqueException, IdNonNullException {
        Service service = new ServiceImplimentation();
        service.ajoutQuestion(new VDQuestion(1, "V0ywCnSiffh4o70ehGg8VJrzfT0Ye36Rme8WSbK84vDckO6sV8sbIN8XQFe5yxTYbkA4P6wvL6Sg3vvtPgOQnZTiKO844HAuZ6WtzbB82tFl5wIQmXmiXPUBamjPzFFj9iI3YGmsem3kmv5uoLtDLoYw3EKMab8SZ5JlrQuudCEbVhxkITJc4ZVe8RqVvzMWg9dGdD37JAzG9DWC0BKlPDB2c4BdrEzimjryoD0Q8vWUKZNe9tkqP7iObtuXyuknG"));
    }
}
