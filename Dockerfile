# Start with a lightweight Python image
FROM python:3.10-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the requirements file into the container
COPY requirements.txt /app/

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy only the Research-paper-code directory and necessary files into the container
COPY Research-paper-code /app/Research-paper-code
COPY requirements.txt /app/

# Set the working directory to Research-paper-code
WORKDIR /app/Research-paper-code

# Run pytest --cov on Research-paper-code directory with coverage
CMD ["pytest", ".", "--cov"]
