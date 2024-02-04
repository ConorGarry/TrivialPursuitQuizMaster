# !/bin/bash

# curl test command for ChatGPT api, adds OPENAI_API_KEY to header
# Usage: ./gtp_prompt_test.sh <prompt>
#
# Example:
# ./gtp_prompt_test.sh "Hello, I am a robot. I am very smart."

prompt=$1

# Create url request:
# url="https://api.openai.com/v1/engines/davinci/completions"
url="https://api.openai.com/v1/chat/completions"
headers="Content-Type: application/json"

# Send a request to the ChatGPT API
response=$(curl -s -X POST \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer $OPENAI_API_KEY" \
    -d '{
      "model": "gpt-3.5-turbo-16k",
      "messages": [{"role": "user", "content": "'"${prompt}"'"}]
    }' \
    "$url")

echo "$response"
