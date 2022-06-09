CREATE DATABASE IF NOT EXISTS MountainWeather;

CREATE TABLE IF NOT EXISTS 'mountain_peak'(
'peak_id' INT AUTO_INCREMENT,
'peak_name' VARCHAR(255) NOT NULL,
'range_id' INT NOT NULL,
'uri' VARCHAR(100) NOT NULL,
PRIMARY KEY (peak_id),
FOREIGN KEY(range_id) REFERENCES 'mountain_range'(id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS 'mountain_range'(
'range_id' INT AUTO_INCREMENT,
'range_name' VARCAHR(255) NOT NULL,
'uri' VARCHAR(100) NOT NULL,
PRIMARY KEY(range_id),
FOREIGN KEY(range_id) REFERENCES 'mountain_peak'(peak_id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS 'users'(
'user_id' INT AUTO_INCREMENT NOT NULL,
'email' VARCHAR(127) NOT NULL,
'first_name' VARCHAR(50),
'last_name' VARCHAR(50),
'password' VARCHAR(255),
PRIMARY KEY(user_id),
FOREIGN KEY(user_id) REFERENCES 'user_profiles'(owner)
) ENGINE=INNODGB;


CREATE TABLE IF NOT EXISTS 'user_profiles'(
'profile_id' AUTO_INCREMENET,
'owner' INT NOT NULL,
'temperature_max' TINYINT,
'temperature_min' TINYINT,
'wind_max' TINYINT,
'preferred_weather_conditions' SET(
	'CLEAR',
    'SOME_CLOUDS',
    'CLOUDY',
    'RAIN_SHWRS',
    'LIGHT_RAIN',
    'MOD_RAIN',
    'HEAVY_RAIN',
    'SNOW_SHWRS',
    'LIGHT_SNOW',
    'MOD_SNOW',
    'HEAVY_SNOW',
    ) NOT NULL,
PRIMARY KEY(profile_id),
FOREIGN KEY(owner) REFERENCES 'users'(user_id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS 'weather_report'(
'report_id' INT AUTO_INCREMENT,
'peak_id' INT NOT NULL,
'time_of_day' ENUM('AM','PM','NIGHT') NOT NULL,
'weather_conditions' ENUM(
	'CLEAR',
    'SOME_CLOUDS',
    'CLOUDY',
    'RAIN_SHWRS',
    'LIGHT_RAIN',
    'MOD_RAIN',
    'HEAVY_RAIN',
    'SNOW_SHWRS',
    'LIGHT_SNOW',
    'MOD_SNOW',
    'HEAVY_SNOW',
    ) NOT NULL,
'temp_high' TINYINT(120) NOT NULL, 
'temp_low' TINYINT(120) NOT NULL,
'temp_chill' TINYINT(120) NOT NULL,
'rainfall_prediction_inches' TINYINT(50),
'snowfall_prediction_inches' TINYINT(100),
'wind_conditions' VARCHAR(10),
PRIMARY KEY(report_id),
FOREIGN KEY(peak_id) REFERENCES 'mountain_peak'(peak_id)
) ENGINE=INNODB;

