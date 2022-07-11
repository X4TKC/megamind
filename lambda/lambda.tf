resource "aws_lambda_function" "chatbot_lambda_function" {
  runtime          = var.lambda_runtime
  filename         = var.lambda_payload_filename
  source_code_hash = filebase64sha256("${var.lambda_payload_filename}")
  function_name    = "chatbot_lambda_function"

  handler     = var.lambda_function_handler
  timeout     = var.timeout
  memory_size = var.memory_size
  role        = aws_iam_role.iam_role_for_lambda.arn
  depends_on  = [aws_cloudwatch_log_group.log_group]

}

resource "aws_lambda_permission" "chatbot_lambda_function" {
  statement_id  = "AllowAPIGatewayInvoke"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.chatbot_lambda_function.function_name
  principal     = "apigateway.amazonaws.com"
  # The /*/* portion grants access from any method on any resource
  # within the API Gateway "REST API".
  #source_arn = "${aws_api_gateway_deployment.chatbot_lambda_deploy.execution_arn}/*/*"
}
