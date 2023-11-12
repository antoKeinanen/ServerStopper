# Server Stopper

ServerStopper is free and opensource server utility for paper based servers. ServerStopper closes the server after
specified time if there are no players. If a player joins during this timer it will be cancelled.

> **Hint:** This plugin works well with the Serverselector pluign

## Installation

1. Download the latest release from the releases page in the GitHub.
2. Put the downloaded jar to the `plugins` folder in your server.
3. Run the server once and stop it to generate the configuration. Alternatively you can copy the config yourself
   to `plugins/ServerStopper/config.toml`.

<details>
  <summary>Default configuration</summary>

   ```toml
    delay = 6000
   ```

</details>

## Configuration

Delay is the time to wait before the server is closed in ticks.

**Default:** `6000` `5min = 300sec = 6000 ticks`

## Roadmap

After this I will consider this plugin completed and only fix bugs.
