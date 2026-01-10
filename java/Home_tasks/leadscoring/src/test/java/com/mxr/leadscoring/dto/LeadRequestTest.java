package com.mxr.leadscoring.dto;

import com.mxr.leadscoring.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LeadRequestTest {

    @Test
    void shouldRejectNullEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeadRequest(
                        null, Position.STAFF, "11-50", "Clicked Ad", 2, 1.5
                )
        );
    }

    @Test
    void shouldRejectInvalidEmailFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeadRequest(
                        "invalid-email", Position.STAFF, "11-50", "Clicked Ad", 2, 1.5
                )
        );
    }

    @Test
    void shouldRejectBlankPosition() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeadRequest(
                        "test@example.com", " ", "11-50", "Clicked Ad", 2, 1.5
                )
        );
    }

    @Test
    void shouldRejectNegativeDaysSinceLead() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeadRequest(
                        "test@example.com", Position.STAFF, "11-50", "Clicked Ad", -1, 1.5
                )
        );
    }

    @Test
    void shouldRejectNegativeResponseTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeadRequest(
                        "test@example.com", Position.STAFF, "11-50", "Clicked Ad", 2, -0.5
                )
        );
    }

    @Test
    void shouldRejectNullPosition() {
        assertThrows(NullPointerException.class,
                () -> new LeadRequest(
                        "test@example.com",
                        null,
                        "11-50",
                        "Clicked Ad",
                        2,
                        1.5
                )
        );
    }

    @Test
    void shouldAcceptValidPosition() {
        LeadRequest request = new LeadRequest(
                "test@example.com",
                Position.OWNER,
                "11-50",
                "Clicked Ad",
                2,
                1.5
        );

        assertEquals(Position.OWNER, request.getPosition());
    }

}
