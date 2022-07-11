resource "aws_s3_bucket" "megamindtest" {
  bucket = "megamindtest"
}

resource "aws_athena_database" "megamind_db" {
  name   = "megamind_db"
  bucket = aws_s3_bucket.megamindtest.bucket
}
