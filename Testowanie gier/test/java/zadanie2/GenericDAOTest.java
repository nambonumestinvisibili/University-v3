package zadanie2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericDAOTest {


    @Mock
    Session session;
    @Mock
    DbLogger dbLogger;

    @InjectMocks
    GenericDAO genericDAO = new GenericDAO();

    @Test
    void WhenSessionOpenThrowsExceptionThen() throws SessionOpenException {
        doThrow(SessionOpenException.class).when(session).open();

        assertThrows(SessionOpenException.class, () -> {
            genericDAO.save(new Object());
        });
    }

    @Test
    void WhenSessionThrowsCommitExceptionDbLoggerShouldReceiveCommitExceptionParameter()
            throws CommitException, SessionOpenException {
        doThrow(CommitException.class).when(session).commitTransaction();
        ArgumentCaptor<Exception> captor = ArgumentCaptor.forClass(Exception.class);
        doNothing().when(dbLogger).log(captor.capture());

        genericDAO.save(new Object());

        assertEquals(CommitException.class.getTypeName(), captor.getValue().getClass().getTypeName());

    }
}