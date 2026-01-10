CREATE TABLE IF NOT EXISTS leads (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20),
    company VARCHAR(255),
    annual_volume DOUBLE,
    trading_experience VARCHAR(50) NOT NULL,
    response_score INTEGER,
    engagement_score INTEGER,
    score_total INTEGER,
    created_at BIGINT DEFAULT CURRENT_TIMESTAMP
    );

CREATE INDEX idx_score_total ON leads(score_total DESC);
CREATE INDEX idx_company ON leads(company);
CREATE INDEX idx_created_at ON leads(created_at DESC);