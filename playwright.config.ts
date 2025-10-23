import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  testDir: './tests',

  /* Run tests in parallel */
  fullyParallel: true,

  /* Fail build on CI if `test.only` accidentally left in */
  forbidOnly: !!process.env.CI,

  /* Retry on CI only */
  retries: process.env.CI ? 2 : 0,

  /* Limit workers on CI to avoid resource contention */
  workers: process.env.CI ? 1 : undefined,

  /* ✅ Reporters: generate HTML + JUnit for TeamCity */
  reporter: [
    ['html',  { open: 'never', outputFolder: 'playwright-report' }],
    ['junit', { outputFile: 'reports/junit.xml' }],
  ],

  /* Default options for all tests */
  use: {
    trace: 'on-first-retry',
  },

  /* Browser projects */
  projects: [
    { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
    { name: 'firefox',  use: { ...devices['Desktop Firefox'] } },
    { name: 'webkit',   use: { ...devices['Desktop Safari'] } },
  ],
});
