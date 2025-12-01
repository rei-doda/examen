# STAGE 1: Build Angular SSR
FROM node:20 AS builder
WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build  # builds browser + server (SSR)

# STAGE 2: Run Angular SSR
FROM node:20-alpine
WORKDIR /app

COPY --from=builder /app/dist/examen-frontend /app/dist

EXPOSE 4000
CMD ["node", "server/server.mjs"]
