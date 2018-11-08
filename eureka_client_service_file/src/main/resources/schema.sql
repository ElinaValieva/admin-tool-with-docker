CREATE TABLE IF NOT EXISTS FILE_MODEL_TABLE (
  name          varchar(100),
	date_duration timestamp,
	token         varchar(100),
	id            serial not null constraint file_manager_pk primary key);

ALTER TABLE FILE_MODEL_TABLE
  owner to filedb;

GRANT ALL PRIVILEGES ON TABLE FILE_MODEL_TABLE TO filedb;