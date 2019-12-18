#!/bin/bash
USERNAME="Blank"
PASSWORD="Blank"

# Manual prompt via echo
echo -n "Type user name: "
read -r USERNAME

# Prompt string before reading user input
# Secured read -s
read -rsp "Type password: " PASSWORD

echo ""
echo "=========================="
echo "Readed username: $USERNAME"
echo "Readed password: $PASSWORD"