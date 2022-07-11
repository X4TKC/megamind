module "upload_lambda_function" {

  source = "./lambda"

  lambda_payload_filename = "./zips/Chatbot.zip"
  lambda_function_handler = "com.lambda.handler.LambdaFunction::handleRequest"
  lambda_runtime          = "java11"
  timeout                 = 360
  memory_size             = 512

}
